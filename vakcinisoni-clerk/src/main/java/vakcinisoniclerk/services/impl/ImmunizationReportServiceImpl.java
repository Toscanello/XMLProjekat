package vakcinisoniclerk.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import vakcinisoniclerk.models.*;
import vakcinisoniclerk.repository.impl.ImmunizationReportRepository;
import vakcinisoniclerk.services.IImunizationReportService;
import vakcinisoniclerk.services.QrService;
import vakcinisoniclerk.xml2pdf.itext.HTMLTransformer;
import vakcinisoniclerk.xml2pdf.xslfo.XSLFOTransformer;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ImmunizationReportServiceImpl implements IImunizationReportService {

    RestTemplate restTemplate = new RestTemplate();

    public XSLFOTransformer transformer = new XSLFOTransformer("data/ImmunizationReport.xml", "data/xsl/ImmunizationReport.xsl", "data/gen/ImmunizationReport.pdf");

    public HTMLTransformer htmlTransformer = new HTMLTransformer();

    public static final String PATH_TO_QR = "data/xsl/images/qr-code.jpg";
    public static final String URL_BASE = "http://www.vakcinisoni/com/ImmunizationReport/";

    @Autowired
    private ImmunizationReportRepository repository;

    public ImmunizationReportServiceImpl() throws IOException, SAXException {
    }

    @Override
    public ImmunizationReport save(ImmunizationReport report) {
        try {
            return repository.save(report);
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reports findAll() {
        try {
            Collection<ImmunizationReport> reports = repository.findAll("/immunizationReport");
            return new Reports((List<ImmunizationReport>) reports);
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String download(String id) {
        try {
            transformer.setINPUT_FILE("data/" + id + ".xml");
            File res = repository.getXml(id);
            //GENERATE QR
            String fullUrl = URL_BASE + id;
            QrService.makeNewQr(fullUrl, PATH_TO_QR);
            transformer.generatePDF();
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @Override
    public String downloadHtml(String id){
        try {
            htmlTransformer.setINPUT_FILE("data/" + id + ".xml");
            htmlTransformer.setXSL_FILE("data/xslt-html/ImmunizationReport.xsl");
            String outputFileName = "ImmunizationReport" + id + ".html";
            htmlTransformer.setHTML_FILE("data/gen/itext/" + outputFileName);
            File res = repository.getXml(id);
            String path = htmlTransformer.generateHTML();
            if(path != null && !path.equals("")){
                return outputFileName;
            }
            return "fail";
        } catch (Exception e) {
            return "fail";
        }
    }

    public ImmunizationReport generateReport(String dateFrom, String dateUntil) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
        Date dateFromD = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
        Date dateUntilD = new SimpleDateFormat("yyyy-MM-dd").parse(dateUntil);

        ResponseEntity<Integer> vaccineCandidatesCount = restTemplate.getForEntity("http://localhost:3000/candidates/count/", Integer.class);
        ResponseEntity<Accordances> accordances = restTemplate.getForEntity("http://localhost:3000/accordances/", Accordances.class);
        ResponseEntity<DigitalCertificates> digitalCertificates = restTemplate.getForEntity("http://localhost:3000/certificates/read/", DigitalCertificates.class);
        ResponseEntity<Integer> digitalCertificateRequestsCount = restTemplate.getForEntity("http://localhost:3000/certificate-requests/count/", Integer.class);


        List<ImmunizationAccordance> accordancesList = Objects.requireNonNull(accordances.getBody()).getAccordance();
        Collection<DigitalCertificate> digitalCertificateList = Objects.requireNonNull(digitalCertificates.getBody()).getCertificate();

        int digitalCertificatesNumber = digitalCertificateList.size();
        int digitalCertificatesRequestsNumber = digitalCertificateRequestsCount.getBody();
        int totalVaccinesGiven = 0;
        Map<Integer, Integer> dosesTable = new HashMap<>();
        Map<String, Integer> dosesByManufacturer = new HashMap<>();

        for (ImmunizationAccordance accordance : accordancesList) {
            Integer i = 0;
            for (ImmunizationAccordance.VaccineEvidence.Table.Row row : accordance.getVaccineEvidence().getTable().getRow()) {
                i++;
                Date dateIssued = new SimpleDateFormat("yyyy-MM-dd").parse(row.getDateIssued());
                if (dateIssued.after(dateFromD) && dateIssued.before(dateUntilD)) {
                    // increase number of total vaccines
                    totalVaccinesGiven++;

                    // increase number of doses
                    if (!dosesTable.containsKey(i)) {
                        dosesTable.put(i, 0);
                    }
                    int currentValue = dosesTable.get(i);
                    dosesTable.put(i, currentValue + 1);

                    // increase number of doses by manufacturer
                    if (!dosesByManufacturer.containsKey(row.getManufacturer())) {
                        dosesByManufacturer.put(row.getManufacturer(), 0);
                    }
                    int currentValueManuf = dosesByManufacturer.get(row.getManufacturer());
                    dosesByManufacturer.put(row.getManufacturer(), currentValueManuf + 1);
                }
            }
        }

        List<ImmunizationReport.Manufacturers.Manufacturer> manufacturerList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : dosesByManufacturer.entrySet()) {
            manufacturerList.add(new ImmunizationReport.Manufacturers.Manufacturer(entry.getKey(), entry.getValue()));
        }

        ImmunizationReport.Manufacturers manufacturers = new ImmunizationReport.Manufacturers(manufacturerList);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        ImmunizationReport report = new ImmunizationReport(dateFrom, dateUntil, vaccineCandidatesCount.getBody()+"",
                digitalCertificatesRequestsNumber+"", digitalCertificatesNumber+"",
                totalVaccinesGiven+"", dosesTable.get(1).toString(), manufacturers, dtf.format(now));

        this.save(report);
        return report;
    }
}
