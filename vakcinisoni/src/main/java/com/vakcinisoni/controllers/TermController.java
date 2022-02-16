package com.vakcinisoni.controllers;

import com.vakcinisoni.models.Term;
import com.vakcinisoni.repository.impl.TermRepository;
import com.vakcinisoni.services.ITermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.base.XMLDBException;

@RestController
@RequestMapping(value = "terms")
public class TermController {

    @Autowired
    private ITermService service;


    @PostMapping(value="/", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<Term> createNew(@RequestBody Term term) {
        Term ret = service.save(term);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
