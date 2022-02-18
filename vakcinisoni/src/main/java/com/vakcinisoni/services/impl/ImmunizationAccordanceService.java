package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.Accordances;
import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.repository.impl.ImmunizationAccordanceRepository;
import com.vakcinisoni.services.IImmunizationAccordanceService;
import com.vakcinisoni.xml2pdf.itext.HTMLTransformer;
import com.vakcinisoni.xml2pdf.xslfo.XSLFOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ImmunizationAccordanceService implements IImmunizationAccordanceService {

    @Autowired
    public ImmunizationAccordanceRepository repository;

    public XSLFOTransformer transformer = new XSLFOTransformer("data/ImmunizationAccordance.xml", "data/xsl/ImmunizationAccordance.xsl", "data/gen/ImmunizationAccordance.pdf");

    public HTMLTransformer htmlTransformer = new HTMLTransformer();

    public ImmunizationAccordanceService() throws IOException, SAXException {
    }

    @Override
    public ImmunizationAccordance save(ImmunizationAccordance accordance) {
        try {
            return repository.save(accordance);
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Accordances findAll() {
        try {
            List<ImmunizationAccordance> accordanceList = (ArrayList<ImmunizationAccordance>)repository.findAll("/accordance");
            return new Accordances(accordanceList);
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Accordances findAllForJmbg(String jmbg) {
        try {
            List<ImmunizationAccordance> accordanceList = repository.findForJmbg(jmbg);
            return new Accordances(accordanceList);
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String download(String id) {
        try {
            transformer.setINPUT_FILE("data/" + id + ".xml");
            File res = repository.getXml(id);
            transformer.generatePDF();
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @Override
    public String downloadHtml(String id) {
        try{
            htmlTransformer.setINPUT_FILE("data/" + id + ".xml");
            htmlTransformer.setXSL_FILE("data/xslt-html/ImmunizationAccordance.xsl");
            String outputFileName = "ImmunizationAccordance" + id + ".html";
            htmlTransformer.setHTML_FILE("data/gen/itext/" + outputFileName);//_" + id + "
            File res = repository.getXml(id);
            String path = htmlTransformer.generateHTML();
            if(path != null && !path.equals("")){
                return outputFileName;
            }
            return "fail";
        }
        catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public Accordances findByPhrase(String phrase) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new Accordances(repository.findAllByPhrase(phrase));
    }
}
