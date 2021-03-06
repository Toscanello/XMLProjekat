package com.vakcinisoni.controllers;

import com.vakcinisoni.models.Accordances;
import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.models.VaccinationReports;
import com.vakcinisoni.services.IImmunizationAccordanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;

@RestController
@RequestMapping(value = "accordances")
public class ImmunizationAccordanceController {

    @Autowired
    private IImmunizationAccordanceService service;

    @PostMapping(value = "/", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<ImmunizationAccordance> save(@RequestBody ImmunizationAccordance accordance){
        ImmunizationAccordance ret = service.save(accordance);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/xml")
    public ResponseEntity<Accordances> getAll(){
        Accordances ret = service.findAll();
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value="/{jmbg}", produces ="application/xml")
    public ResponseEntity<Accordances> getAllForJmbg(@PathVariable String jmbg){
        Accordances ret = service.findAllForJmbg(jmbg);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @GetMapping(value = "/download/{id}")
    public ResponseEntity<String> download(@PathVariable String id){
        String ret = service.download(id);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @GetMapping(value="/downloadhtml/{id}")
    public ResponseEntity<String> downloadHtml(@PathVariable String id){
        String ret = service.downloadHtml(id);
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
    @GetMapping(value = "/simple-search/{phrase}", produces = "application/xml")
    public ResponseEntity<Accordances> findByPhrase(@PathVariable String phrase) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(service.findByPhrase(phrase),HttpStatus.OK);
    }

}
