package com.vakcinisoni.controllers;

import com.vakcinisoni.models.Term;
import com.vakcinisoni.models.VaccineCandidate;
import com.vakcinisoni.models.VaccineCandidates;
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
        if (freeTerm.equals(null))
            return new ResponseEntity<>(freeTerm, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(freeTerm, HttpStatus.OK);
    }

    @GetMapping(value="/count")
    public ResponseEntity<Integer> count(){
        return new ResponseEntity<>(service.countDistinct(), HttpStatus.OK);
    }

    @GetMapping(value="/filter/{jmbg}", produces = "application/xml")
    public ResponseEntity<VaccineCandidates> getAllForJmbg(@PathVariable String jmbg){
        VaccineCandidates ret = service.findAllForJmbg(jmbg);
        return new ResponseEntity<>(ret, HttpStatus.OK);
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
