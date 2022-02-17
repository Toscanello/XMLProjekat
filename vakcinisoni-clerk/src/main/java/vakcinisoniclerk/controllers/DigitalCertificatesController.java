package vakcinisoniclerk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vakcinisoniclerk.models.DigitalCertificateRequests;
import vakcinisoniclerk.models.VaccinationReports;
import vakcinisoniclerk.models.dto.DeclineCertificateRequestDto;
import vakcinisoniclerk.services.ICertificatesService;

@RestController
@RequestMapping(value = "certificates")
public class DigitalCertificatesController {

    @Autowired
    private ICertificatesService certificatesService;

    @GetMapping(value = "/vaccination-reports", produces = "application/xml")
    public ResponseEntity<VaccinationReports> findByJmbg(@RequestParam("jmbg") String jmbg) {
        return new ResponseEntity<>(certificatesService.getByJmbg(jmbg), HttpStatus.OK);
    }

    @GetMapping(value = "/fetchRequests", produces = "application/xml")
    public ResponseEntity<DigitalCertificateRequests> findAllRequests() {
        return new ResponseEntity<>(certificatesService.getRequests(), HttpStatus.OK);
    }

    @GetMapping(value = "/{documentId}/accept")
    public ResponseEntity<String> acceptCertificateRequest(@PathVariable("documentId") String jmbg) {
        return new ResponseEntity<>(certificatesService.acceptCertificateRequest(documentId), HttpStatus.OK);
    }

    @PostMapping(value = "/{documentId}/decline", consumes = "application/xml")
    public ResponseEntity<String> declineCertificateRequest(@PathVariable("documentId") String jmbg, @RequestBody DeclineCertificateRequestDto declineRequest) {
        return new ResponseEntity<>(certificatesService.declineCertificateRequest(documentId, declineRequest), HttpStatus.OK);
    }

}
