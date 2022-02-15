package com.vakcinisoni.controllers;

import com.vakcinisoni.models.Accordances;
import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.services.IImmunizationAccordanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
