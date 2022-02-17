package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.Citizen;
import com.vakcinisoni.models.Credentials;
import com.vakcinisoni.repository.impl.CitizenRepository;
import com.vakcinisoni.security.TokenUtils;
import com.vakcinisoni.services.ICitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

@Service
public class CitizenService implements ICitizenService {

    @Autowired
    public CitizenRepository repository;

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public String register(Citizen citizen) {
        try {
            if(citizen.getEmail().equals("") || citizen.getPassword().length() < 5 || citizen.getJmbg().length() < 12){
                return "";
            }
            Citizen c = repository.save(citizen);
            String jwt = "";
            if(c != null){
                jwt = tokenUtils.generateToken(c.getJmbg());
            }
            return jwt;

        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String login(Credentials credentials) {
        try {
            Citizen c = repository.findOne(credentials.getJmbg());
            String jwt = "";
            if(c != null && c.getPassword().equals(credentials.getPassword())){
                jwt = tokenUtils.generateToken(c.getJmbg());
            }
            return jwt;

        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }
}
