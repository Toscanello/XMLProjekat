package vakcinisoniclerk.services.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vakcinisoniclerk.models.Accordances;
import vakcinisoniclerk.models.AllDocumentsForCitizen;
import vakcinisoniclerk.models.DigitalCertificates;
import vakcinisoniclerk.models.VaccinationReports;
import vakcinisoniclerk.services.IClerkService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClerkService implements IClerkService {
    RestTemplate restTemplate = new RestTemplate();
    
    @Override
    public AllDocumentsForCitizen getAllDocumentsByPhrase(String phrase) {
        AllDocumentsForCitizen allDocuments = new AllDocumentsForCitizen();
        ResponseEntity<Accordances> accordancesResponseEntity = restTemplate.getForEntity("http://localhost:3000/accordances/simple-search/"+phrase,Accordances.class);
        allDocuments.setAccordances(accordancesResponseEntity.getBody());
        ResponseEntity<DigitalCertificates> digitalCertificatesResponseEntity = restTemplate.getForEntity("http://localhost:3000/certificates/simple-search/"+phrase,DigitalCertificates.class);
        allDocuments.setDigitalCertificates(digitalCertificatesResponseEntity.getBody());
        ResponseEntity<VaccinationReports> vaccinationReportsResponseEntity = restTemplate.getForEntity("http://localhost:3000/vaccine-reports/simple-search/"+phrase,VaccinationReports.class);
        allDocuments.setVaccinationReports(vaccinationReportsResponseEntity.getBody());
        return allDocuments;
    }
}
