package com.vakcinisoni.controllers;

import com.vakcinisoni.models.VaccinationReport;
import com.vakcinisoni.models.VaccinationReports;
import com.vakcinisoni.services.IVaccinationReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;

import javax.ws.rs.QueryParam;

@RestController
@RequestMapping(value="vaccine-reports")
public class VaccineReportController {

    @Autowired
    private IVaccinationReportService service;

    @GetMapping(value = "/", produces = "application/xml")
    public ResponseEntity<VaccinationReports> getReportsForCitizen(@QueryParam("jmbg") String jmbg){
        VaccinationReports reports = service.findAllByJmbg(jmbg);

        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<VaccinationReport> save(@RequestBody VaccinationReport report){
        VaccinationReport ret = service.save(report);

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
    @GetMapping(value = "/simple-search/{phrase}", produces = "application/xml")
    public ResponseEntity<VaccinationReports> findByPhrase(@PathVariable String phrase) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(service.findByPhrase(phrase),HttpStatus.OK);
    }


}
