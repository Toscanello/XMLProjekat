package vakcinisoniclerk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;
import vakcinisoniclerk.models.ImmunizationReport;
import vakcinisoniclerk.services.IImunizationReportService;

import java.text.ParseException;


@RestController
@RequestMapping(value = "immunization-reports")
public class ImmunizationReportController {

    @Autowired
    private IImunizationReportService service;

    @GetMapping(value = "/generate", produces = "application/xml")
    public ResponseEntity<ImmunizationReport> generateReport(@RequestParam("dateFrom") String dateFrom, @RequestParam("dateUntil") String dateUntil) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
        return new ResponseEntity<>(service.generateReport(dateFrom, dateUntil), HttpStatus.OK);
    }
}
