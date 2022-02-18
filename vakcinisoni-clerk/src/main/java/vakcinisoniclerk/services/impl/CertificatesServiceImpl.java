package vakcinisoniclerk.services.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vakcinisoniclerk.models.*;
import vakcinisoniclerk.models.dto.DeclineCertificateRequestDto;
import vakcinisoniclerk.models.enums.Gender;
import vakcinisoniclerk.services.MailerService;
import vakcinisoniclerk.services.ICertificatesService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertificatesServiceImpl implements ICertificatesService {

    RestTemplate restTemplate = new RestTemplate();

    public VaccinationReports getByJmbg(String jmbg) {
        ResponseEntity<VaccinationReports> vaccinationReports = restTemplate.getForEntity("http://localhost:3000/vaccine-reports/?jmbg="+jmbg, VaccinationReports.class);
        VaccinationReports reports = vaccinationReports.getBody();
        return reports;
    }

    public DigitalCertificateRequests getRequests() {
        ResponseEntity<DigitalCertificateRequests> digitalRequests = restTemplate.getForEntity("http://localhost:3000/certificate-requests/", DigitalCertificateRequests.class);
        DigitalCertificateRequests requests = digitalRequests.getBody();
        return requests;
    }

    public DigitalCertificateRequests getCertificatesByJmbg(String jmbg) {
        ResponseEntity<DigitalCertificateRequests> digitalRequests = restTemplate.getForEntity("http://localhost:3000/certificate-requests/byJmbg?jmbg=" + jmbg, DigitalCertificateRequests.class);
        DigitalCertificateRequests requests = digitalRequests.getBody();
        return requests;
    }

    public String acceptCertificateRequest(String documentId){
        String jmbg = documentId.split("-")[0];
        VaccinationReport vaccinationReport = this.getByJmbg(jmbg).getVaccinationReport().get(0);
        DigitalCertificateRequest certificateRequest = this.getCertificatesByJmbg(jmbg).getCertificateRequest().get(0);

        List<Dose> certificateDoses = new ArrayList<>();

        for (Dose dose : vaccinationReport.getDoses().getDose()) {
            certificateDoses.add(new Dose(vaccinationReport.getVaccine(), "manufacturer", dose.getDate(), dose.getBatch(), vaccinationReport.getInstitution()));
        }

        Vaccination vaccination = new Vaccination(certificateDoses);

        ResponseEntity<DigitalCertificates> digitalCertificates = restTemplate.getForEntity("http://localhost:3000/certificates/read/", DigitalCertificates.class);
        int size = 0;
        if (digitalCertificates.getBody().getCertificate() != null) {
            size = digitalCertificates.getBody().getCertificate().size();
        }

        DigitalCertificate newDigitalCertificate = new DigitalCertificate(size + 1 + "", vaccinationReport.getQrCode(), vaccinationReport.getFullName(),
                Gender.convertNumberToEnum(vaccinationReport.getGender()), vaccinationReport.getBirthDate(), jmbg, certificateRequest.getPassportNum(),
                vaccination);

        ResponseEntity<DigitalCertificate> createdCert = restTemplate.postForEntity("http://localhost:3000/certificates/write", new HttpEntity<>(newDigitalCertificate), DigitalCertificate.class);
        System.out.println("http://localhost:3000/certificates/download/" + createdCert.getBody().getId());
        // TODO: fetch converted (in PDF and XHTML) certificate format and attach it to a mail
        ResponseEntity<String> pdf = restTemplate.getForEntity("http://localhost:3000/certificates/download/" + createdCert.getBody().getId(), String.class);
        ResponseEntity<String> html = restTemplate.getForEntity("http://localhost:3000/certificates/downloadhtml/" + createdCert.getBody().getId(), String.class);

        String pdfPath = "/home/svetozar/Documents/Faks/XML/XMLProjekat/vakcinisoni/data/gen/DigitalCert.pdf";
        String xhtmlPath = "/home/svetozar/Documents/Faks/XML/XMLProjekat/vakcinisoni/data/gen/itext/DigitalCert1.html";

        // TODO: send email
        MailerService.sendAcceptedMail("svetozar.vulin@gmail.com", "Svetozar", pdfPath, xhtmlPath);
        restTemplate.delete("http://localhost:3000/certificate-requests/" + documentId + "/");

        return "email sent";
    }

    public String declineCertificateRequest(String documentId, DeclineCertificateRequestDto declineRequest) {
        // TODO: delete request doc from database
        restTemplate.delete("http://localhost:3000/certificate-requests/" + documentId + "/");

        // TODO: send email
        MailerService.sendDeclineMail("svetozar.vulin@gmail.com", "Svetozar", declineRequest.getMessage());

        return "email sent";
    }
}
