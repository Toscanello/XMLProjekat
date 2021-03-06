package com.vakcinisoni.controllers;

import com.vakcinisoni.models.Citizen;
import com.vakcinisoni.models.Credentials;
import com.vakcinisoni.repository.impl.CitizenRepository;
import com.vakcinisoni.security.TokenUtils;
import com.vakcinisoni.services.ICitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;

@RestController
@RequestMapping(value = "citizens")
public class CitizenController {

    @Autowired
    private ICitizenService service;

    @PostMapping(value="/register", consumes="application/xml", produces="application/xml")
    public ResponseEntity<Citizen> register(@RequestBody Citizen citizen) {
        String jwt = service.register(citizen);
        citizen.setToken(jwt);
        if(!jwt.equals("")){
            return new ResponseEntity<>(citizen, HttpStatus.OK);
        }
        return new ResponseEntity<>(citizen, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/login", consumes="application/xml", produces="application/xml")
    public ResponseEntity<Citizen> login(@RequestBody Credentials credentials) {
        Citizen jwt = service.login(credentials);

        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value="/protected")
    public ResponseEntity<Boolean> test(){
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
