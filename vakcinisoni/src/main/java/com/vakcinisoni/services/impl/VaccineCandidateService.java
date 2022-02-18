package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.*;
import com.vakcinisoni.repository.impl.TermRepository;
import com.vakcinisoni.repository.impl.VaccineCandidateRepository;
import com.vakcinisoni.services.IVaccineCandidateService;
import com.vakcinisoni.services.MailerService;
import com.vakcinisoni.xml2pdf.itext.HTMLTransformer;
import com.vakcinisoni.xml2pdf.xslfo.XSLFOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

@Service
public class VaccineCandidateService implements IVaccineCandidateService {

    @Autowired
    public VaccineCandidateRepository candidateRepository;

    @Autowired
    public TermRepository termRepository;

    RestTemplate restTemplate = new RestTemplate();

    public XSLFOTransformer transformer = new XSLFOTransformer("data/VaccineCandidate.xml", "data/xsl/VaccineCandidate.xsl", "data/gen/VaccineCandidate.pdf");

    public HTMLTransformer htmlTransformer = new HTMLTransformer();

    public VaccineCandidateService() throws IOException, SAXException {
    }

    @Override
    public Term save(VaccineCandidate candidate) {
        try{
            candidateRepository.save(candidate);
            Term term = termRepository.findFirstFree(candidate);
            term.setTaken(true);
            String xPathSelector = "/term/taken";

            ResponseEntity<Vaccines> vaccines = restTemplate.getForEntity("http://localhost:3001/vaccines/", Vaccines.class);
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

    @Override
    public int countDistinct() {
        try {
            return candidateRepository.countDistinct();
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public VaccineCandidates findAllForJmbg(String jmbg) {
        try {
            List<VaccineCandidateWithId> candidates = candidateRepository.findForJmbg(jmbg);
            return new VaccineCandidates(candidates);
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String download(String id) {
        try {
            transformer.setINPUT_FILE("data/" + id + ".xml");
            File res = candidateRepository.getXml(id);
            transformer.generatePDF();
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @Override
    public String downloadHtml(String id) {
        try {
            htmlTransformer.setINPUT_FILE("data/" + id + ".xml");
            htmlTransformer.setXSL_FILE("data/xslt-html/VaccineCandidate.xsl");
            String outputFileName = "VaccineCandidate" + id + ".html";
            htmlTransformer.setHTML_FILE("data/gen/itext/" + outputFileName);
            File res = candidateRepository.getXml(id);
            String path = htmlTransformer.generateHTML();
            if(path != null && !path.equals("")){
                return outputFileName;
            }
            return "fail";
        } catch (Exception e) {
            return "fail";
        }
    }


}
