package com.vakcinisoni.controllers;

import com.vakcinisoni.models.DigitalCertificate;
import com.vakcinisoni.models.DigitalCertificates;
import com.vakcinisoni.services.IDigitalCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "certificates")
public class DigitalCertificateController {

    @Autowired
    private IDigitalCertificateService service;

    @GetMapping(value = "/read", produces = "application/xml")
    public ResponseEntity<DigitalCertificates> findAll() {
        DigitalCertificates dc = service.findAll();

        return new ResponseEntity<>(dc, HttpStatus.OK);
    }


    @PostMapping(value = "/write", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<DigitalCertificate> save(@RequestBody DigitalCertificate certificate) {
        DigitalCertificate dc = service.save(certificate);

        return new ResponseEntity<>(dc, HttpStatus.OK);
    }

    @GetMapping(value="/read/{jmbg}", produces = "application/xml")
    public ResponseEntity<DigitalCertificates> findAllByJmbg(@PathVariable String jmbg){
        DigitalCertificates dc = service.findAllByJmbg(jmbg);

        return new ResponseEntity<>(dc, HttpStatus.OK);
    }

    @GetMapping(value = "/download/{id}")
    public ResponseEntity<String> download(@PathVariable String id){
        String ret = service.download(id);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @GetMapping(value = "/downloadhtml/{id}")
    public ResponseEntity<String> downloadHtml(@PathVariable String id){
        String ret = service.downloadHtml(id);

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
