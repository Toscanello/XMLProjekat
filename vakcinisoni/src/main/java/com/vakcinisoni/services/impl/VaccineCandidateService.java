package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.Term;
import com.vakcinisoni.models.VaccineCandidate;
import com.vakcinisoni.repository.impl.TermRepository;
import com.vakcinisoni.repository.impl.VaccineCandidateRepository;
import com.vakcinisoni.services.IVaccineCandidateService;
import com.vakcinisoni.services.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import java.text.ParseException;

@Service
public class VaccineCandidateService implements IVaccineCandidateService {

    @Autowired
    public VaccineCandidateRepository candidateRepository;

    @Autowired
    public TermRepository termRepository;

    @Override
    public Term save(VaccineCandidate candidate) {
        try{
            candidateRepository.save(candidate);
            Term term = termRepository.findFirstFree(candidate);
            term.setTaken(true);
            String xPathSelector = "/term/taken";
            termRepository.update(term.getStart() + "", xPathSelector, "true");
            MailerService.sendConfirmationEmailToVaccineCandidate(candidate, term, "ATTACHMENT");
            return term;
            //return valid term -- DONE
            //send confirmation email
            //SEE IF THERE IS ENOUGH DOSE OF VACCINE FROM CLERK ^
        }
        catch(XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException | ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    //TermRepository


}
