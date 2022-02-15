package com.vakcinisoni.controllers;

import com.vakcinisoni.models.Term;
import com.vakcinisoni.models.VaccineCandidate;
import com.vakcinisoni.services.IVaccineCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "candidates")
public class VaccineCandidateController {

    @Autowired
    private IVaccineCandidateService service;

    @PostMapping(value = "/", consumes="application/xml", produces = "application/xml")
    public ResponseEntity<Term> saveAndNotify(@RequestBody VaccineCandidate candidate){
        Term freeTerm = service.save(candidate);

        return new ResponseEntity<>(freeTerm, HttpStatus.OK);
    }

//    @GetMapping(value="/count", produces = "application/xml")
//    public ResponseEntity<VaccineCandidates>
}
