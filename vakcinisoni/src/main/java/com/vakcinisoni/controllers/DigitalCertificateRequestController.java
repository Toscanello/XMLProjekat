package com.vakcinisoni.controllers;

import com.vakcinisoni.models.DigitalCertificateRequest;
import com.vakcinisoni.models.DigitalCertificateRequests;
import com.vakcinisoni.models.VaccinationReports;
import com.vakcinisoni.services.IDigitalCertificateRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;

import javax.ws.rs.QueryParam;

@RestController
@RequestMapping(value = "certificate-requests")
public class DigitalCertificateRequestController {

    @Autowired
    private IDigitalCertificateRequestService service;

    @GetMapping(value = "/count")
    public ResponseEntity<Integer> countAll() {
        DigitalCertificateRequests requests = service.findAll();
        return new ResponseEntity<>(requests.getCertificateRequest().size(), HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<DigitalCertificateRequests> findAll() {
        DigitalCertificateRequests requests = service.findAll();
        return new ResponseEntity<>(new DigitalCertificateRequests(requests.getCertificateRequest()), HttpStatus.OK);
    }

    @GetMapping(value = "/byJmbg", produces = "application/xml")
    public ResponseEntity<DigitalCertificateRequests> getAllByJmbg(@QueryParam("jmbg") String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DigitalCertificateRequests requests = service.findAllByJmbg(jmbg);

        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping(value="/", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<DigitalCertificateRequest> save(@RequestBody DigitalCertificateRequest request){
        DigitalCertificateRequest saved = service.save(request);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping(value = "download/{id}")
    public ResponseEntity<String> download(@PathVariable String id){
        String ret = service.download(id);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{documentId}")
    public ResponseEntity<String> delete(@PathVariable String documentId) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        service.delete(documentId);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
