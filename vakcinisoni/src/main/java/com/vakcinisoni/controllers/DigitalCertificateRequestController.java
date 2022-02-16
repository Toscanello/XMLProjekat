package com.vakcinisoni.controllers;

import com.vakcinisoni.models.DigitalCertificateRequest;
import com.vakcinisoni.services.IDigitalCertificateRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "download/{id}")
    public ResponseEntity<String> download(@PathVariable String id){
        String ret = service.download(id);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
