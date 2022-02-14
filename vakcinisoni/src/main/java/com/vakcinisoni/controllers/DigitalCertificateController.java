package com.vakcinisoni.controllers;

import com.vakcinisoni.models.DigitalCertificate;
import com.vakcinisoni.models.DigitalCertificates;
import com.vakcinisoni.repository.impl.DigitalCertificateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "certificates")
public class DigitalCertificateController {

    private DigitalCertificateRepository repository = new DigitalCertificateRepository();

    public DigitalCertificateController() throws IOException {
    }

    @GetMapping(value = "/read", produces = "application/xml")
    public ResponseEntity<DigitalCertificates> findAll() throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<DigitalCertificate> coll = (ArrayList<DigitalCertificate>) repository.findAll("/certificate");
        DigitalCertificates dc = new DigitalCertificates(coll);

        return new ResponseEntity<>(dc, HttpStatus.OK);
    }

    @PostMapping(value = "/write", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<DigitalCertificate> save(@RequestBody DigitalCertificate certificate) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DigitalCertificate dc = repository.save(certificate);

        return new ResponseEntity<>(dc, HttpStatus.OK);
    }
}
