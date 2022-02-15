package com.vakcinisoni.controllers;

import com.vakcinisoni.models.DigitalCertificate;
import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.repository.impl.CrudRepository;
import com.vakcinisoni.services.IDigitalCertificateService;
import com.vakcinisoni.services.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.base.XMLDBException;

@RestController
@RequestMapping(value = "immunization")
public class MedicalWorkerController{
    @Autowired
    private IMedicalService service;

    @GetMapping(value = "/accordance/{jmbg}")
    public ResponseEntity<ImmunizationAccordance> findOneByJmbg(@PathVariable String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(service.findOneByJmbg(jmbg), HttpStatus.OK);
    }

}