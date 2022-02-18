package vakcinisoniclerk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vakcinisoniclerk.models.AllDocumentsForCitizen;
import vakcinisoniclerk.services.IClerkService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "clerk",produces = {MediaType.APPLICATION_XML_VALUE})
public class ClerkController {

    @Autowired
    IClerkService service;

    @GetMapping(value = "/simple-search/{phrase}",produces = "application/xml")
    public ResponseEntity<AllDocumentsForCitizen> getAllDocumentsByPhrase(@PathVariable String phrase){
        return new ResponseEntity<>(service.getAllDocumentsByPhrase(phrase), HttpStatus.OK);
    }
}
