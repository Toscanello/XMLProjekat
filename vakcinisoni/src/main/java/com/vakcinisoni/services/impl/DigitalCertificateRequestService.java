package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.DigitalCertificate;
import com.vakcinisoni.models.DigitalCertificateRequest;
import com.vakcinisoni.models.DigitalCertificateRequests;
import com.vakcinisoni.models.DigitalCertificates;
import com.vakcinisoni.repository.impl.DigitalCertificateRequestRepository;
import com.vakcinisoni.services.IDigitalCertificateRequestService;
import com.vakcinisoni.xml2pdf.itext.HTMLTransformer;
import com.vakcinisoni.xml2pdf.xslfo.XSLFOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

@Service
public class DigitalCertificateRequestService implements IDigitalCertificateRequestService {

    @Autowired
    public DigitalCertificateRequestRepository repository;

    public XSLFOTransformer transformer = new XSLFOTransformer("data/DigitalCertificateRequest.xml", "data/xsl/DigitalCertificateRequest.xsl", "data/gen/DigitalCertificateRequest.pdf");

    public HTMLTransformer htmlTransformer = new HTMLTransformer();

    public DigitalCertificateRequestService() throws IOException, SAXException {
    }

    @Override
    public DigitalCertificateRequests findAll() {
        try {
            Collection<DigitalCertificateRequest> coll = repository.findAll("/certificateRequest");
            return new DigitalCertificateRequests((List<DigitalCertificateRequest>) coll);

        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DigitalCertificateRequests findAllByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new DigitalCertificateRequests(repository.findByJmbg(jmbg));
    }

    @Override
    public DigitalCertificateRequest save(DigitalCertificateRequest request) {
        try {
            return repository.save(request);
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
    public void delete(String documentId) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        repository.delete(documentId);
    }
    
    public String downloadHtml(String id) {
        try {
            htmlTransformer.setINPUT_FILE("data/" + id + ".xml");
            htmlTransformer.setXSL_FILE("data/xslt-html/DigitalCertificateRequest.xsl");
            String outputFileName = "DigitalCertificateRequest" + id + ".html";
            htmlTransformer.setHTML_FILE("data/gen/itext/" + outputFileName);
            File res = repository.getXml(id);
            String path = htmlTransformer.generateHTML();
            if(path != null && !path.equals("")){
                return outputFileName;
            }
            return "fail";
        } catch (Exception e) {
            return "fail";
        }
    }

    @Override
    public DigitalCertificateRequests findAllForJmbg(String jmbg) {
        try {
            List<DigitalCertificateRequest> requestList = repository.findForJmbg(jmbg);
            return new DigitalCertificateRequests(requestList);
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
