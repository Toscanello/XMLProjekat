package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.VaccinationReport;
import com.vakcinisoni.models.VaccinationReports;
import com.vakcinisoni.repository.impl.VaccinationReportRepository;
import com.vakcinisoni.services.IVaccinationReportService;
import com.vakcinisoni.xml2pdf.xslfo.XSLFOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

import java.io.File;
import java.io.IOException;

@Service
public class VaccinationReportService implements IVaccinationReportService {

    @Autowired
    public VaccinationReportRepository repository;

    public XSLFOTransformer transformer = new XSLFOTransformer("data/VaccinationReport.xml", "data/xsl/VaccineReport.xsl", "data/gen/VaccinationReport.pdf");

    public VaccinationReportService() throws IOException, SAXException {
    }

    @Override
    public VaccinationReports findAllByJmbg(String jmbg) {
        try {
            return new VaccinationReports(repository.findAllByJmbg(jmbg));
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public VaccinationReport save(VaccinationReport report) {
        try {
            return repository.save(report);
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
            transformer.generatePDF();
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }
}
