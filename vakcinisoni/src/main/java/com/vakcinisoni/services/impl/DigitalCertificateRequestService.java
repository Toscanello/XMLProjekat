package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.DigitalCertificateRequest;
import com.vakcinisoni.repository.impl.DigitalCertificateRequestRepository;
import com.vakcinisoni.services.IDigitalCertificateRequestService;
import com.vakcinisoni.xml2pdf.xslfo.XSLFOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;

import java.io.File;
import java.io.IOException;

@Service
public class DigitalCertificateRequestService implements IDigitalCertificateRequestService {

    @Autowired
    public DigitalCertificateRequestRepository repository;

    public XSLFOTransformer transformer = new XSLFOTransformer("data/DigitalCertificateRequest.xml", "data/xsl/DigitalCertificateRequest.xsl", "data/gen/DigitalCertificateRequest.pdf");

    public DigitalCertificateRequestService() throws IOException, SAXException {
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
}
