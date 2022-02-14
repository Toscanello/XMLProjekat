package com.vakcinisoni.controllers;

import com.vakcinisoni.models.Citizen;
import com.vakcinisoni.models.Credentials;
import com.vakcinisoni.repository.impl.CitizenRepository;
import com.vakcinisoni.security.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;

@RestController
@RequestMapping(value = "citizens")
public class CitizenController {

    private CitizenRepository repository = new CitizenRepository();

    @Autowired
    private TokenUtils tokenUtils;

    public CitizenController() throws IOException {
    }

    @PostMapping(value="/register", consumes="application/xml", produces="application/xml")
    public ResponseEntity<String> register(@RequestBody Citizen citizen) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Citizen c = repository.save(citizen);
        String jwt = "";
        if(c != null){
            jwt = tokenUtils.generateToken(c.getJmbg());
        }
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @PostMapping(value = "/login", consumes="application/xml", produces="application/xml")
    public ResponseEntity<String> login(@RequestBody Credentials credentials) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Citizen c = repository.findOne(credentials.getJmbg());

        String jwt = "";
        if(c != null && c.getPassword().equals(credentials.getPassword())){
            jwt = tokenUtils.generateToken(c.getJmbg());
        }
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @GetMapping(value="/protected")
    public ResponseEntity<Boolean> test(){
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
