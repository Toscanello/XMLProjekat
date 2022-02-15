package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.Term;
import com.vakcinisoni.models.Vaccine;
import com.vakcinisoni.models.VaccineCandidate;
import com.vakcinisoni.models.Vaccines;
import com.vakcinisoni.repository.impl.TermRepository;
import com.vakcinisoni.repository.impl.VaccineCandidateRepository;
import com.vakcinisoni.services.IVaccineCandidateService;
import com.vakcinisoni.services.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xmldb.api.base.XMLDBException;

import java.text.ParseException;

@Service
public class VaccineCandidateService implements IVaccineCandidateService {

    @Autowired
    public VaccineCandidateRepository candidateRepository;

    @Autowired
    public TermRepository termRepository;

    RestTemplate restTemplate = new RestTemplate();

//    @Autowired
//    public RestTemplate template;

    @Override
    public Term save(VaccineCandidate candidate) {
        try{
            candidateRepository.save(candidate);
            Term term = termRepository.findFirstFree(candidate);
            term.setTaken(true);
            String xPathSelector = "/term/taken";

            ResponseEntity<Vaccines> vaccines = restTemplate.getForEntity("http://localhost:3001/vaccines", Vaccines.class);
            Vaccines vaccineList = vaccines.getBody();

            for(Vaccine vaccine : vaccineList.getVaccine()){
                System.out.println(vaccine);
                if(candidate.getOptions().getManufacturer().contains(vaccine.getManufacturer()) && vaccine.getQuantity() > 0){
                    termRepository.update(term.getStart() + "", xPathSelector, "true");
                    MailerService.sendConfirmationEmailToVaccineCandidate(candidate, term, "ATTACHMENT");
                    return term;
                }
            }
            return new Term();
            //check if he has no doses taken
        }
        catch(XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException | ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    //TermRepository


}
