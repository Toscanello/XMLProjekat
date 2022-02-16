package vakcinisoniclerk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vakcinisoniclerk.models.dto.DeclineCertificateRequestDto;
import vakcinisoniclerk.services.ICertificatesService;

@RestController
@RequestMapping(value = "certificates")
public class DigitalCertificatesController {

    @Autowired
    private ICertificatesService certificatesService;

    @GetMapping(value = "/{requestId}/accept")
    public ResponseEntity<String> acceptCertificateRequest(@PathVariable("requestId") String requestId) {
        return new ResponseEntity<>(certificatesService.acceptCertificateRequest(requestId), HttpStatus.OK);
    }

    @PostMapping(value = "/{requestId}/decline", consumes = "application/xml")
    public ResponseEntity<String> declineCertificateRequest(@PathVariable("requestId") String requestId, @RequestBody DeclineCertificateRequestDto declineRequest) {
        return new ResponseEntity<>(certificatesService.declineCertificateRequest(requestId, declineRequest), HttpStatus.OK);
    }

}
