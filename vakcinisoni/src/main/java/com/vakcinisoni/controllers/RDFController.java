package com.vakcinisoni.controllers;

import com.vakcinisoni.api.rdf.FusekiWriter;
import com.vakcinisoni.util.AuthenticationUtilities;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "rdf")
public class RDFController {

    @GetMapping("/write/{filename}")
    public ResponseEntity<Object> write(@PathVariable String filename) throws IOException {
        FusekiWriter writer = new FusekiWriter(filename);
        writer.run(AuthenticationUtilities.loadProperties());
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
