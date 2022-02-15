package com.vakcinisoni.controllers;

import com.vakcinisoni.models.DigitalCertificateRequest;
import com.vakcinisoni.services.IDigitalCertificateRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "certificate-requests")
public class DigitalCertificateRequestController {

    @Autowired
    private IDigitalCertificateRequestService service;

    @PostMapping(value="/", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<DigitalCertificateRequest> save(@RequestBody DigitalCertificateRequest request){
        DigitalCertificateRequest saved = service.save(request);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
}