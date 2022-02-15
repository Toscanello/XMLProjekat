package com.vakcinisoni.controllers;

import com.vakcinisoni.models.DigitalCertificate;
import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.repository.impl.CrudRepository;
import com.vakcinisoni.repository.impl.ImmunizationAccordanceRepository;
import com.vakcinisoni.services.IDigitalCertificateService;
import com.vakcinisoni.services.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;

@RestController
@RequestMapping(value = "immunization",produces = {MediaType.APPLICATION_XML_VALUE})
public class MedicalWorkerController{

    @Autowired
    private IMedicalService service;

    @GetMapping(value = "/accordance/{jmbg}")
    public ResponseEntity<ImmunizationAccordance> findOneByJmbg(@PathVariable String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ImmunizationAccordance immunizationAccordance = service.findOneByJmbg(jmbg);
        if (immunizationAccordance==null)
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(immunizationAccordance, HttpStatus.OK);
    }

    @PostMapping(value = "/accordance/{jmbg}",consumes = "application/xml")
    public ResponseEntity<ImmunizationAccordance> addVaccineEvidence(@PathVariable String jmbg, @RequestBody ImmunizationAccordance.VaccineEvidence vaccineEvidence) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(service.addVaccineEvidence(jmbg,vaccineEvidence),HttpStatus.OK);
    }

}