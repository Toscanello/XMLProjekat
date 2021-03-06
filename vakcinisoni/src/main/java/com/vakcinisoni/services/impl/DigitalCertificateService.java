package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.DigitalCertificate;
import com.vakcinisoni.models.DigitalCertificates;
import com.vakcinisoni.repository.impl.DigitalCertificateRepository;
import com.vakcinisoni.services.IDigitalCertificateService;
import com.vakcinisoni.services.QrService;
import com.vakcinisoni.xml2pdf.itext.HTMLTransformer;
import com.vakcinisoni.xml2pdf.xslfo.XSLFOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import java.util.List;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

@Service
public class DigitalCertificateService implements IDigitalCertificateService {

    @Autowired
    public DigitalCertificateRepository repository;

    public XSLFOTransformer transformer = new XSLFOTransformer("data/DigitalCert.xml", "data/xsl/DigitalCert.xsl", "data/gen/DigitalCert.pdf");

    public HTMLTransformer htmlTransformer = new HTMLTransformer();

    public static final String PATH_TO_QR = "data/xsl/images/qr-code.jpg";
    public static final String URL_BASE = "http://www.vakcinisoni/com/DigitalCertificate/";

    public DigitalCertificateService() throws IOException, SAXException {
    }

    @Override
    public DigitalCertificates findAll() {
        try {
            Collection<DigitalCertificate> coll = repository.findAll("/certificate");
            return new DigitalCertificates(coll);

        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DigitalCertificate save(DigitalCertificate certificate) {
        try {
            return repository.save(certificate); // validations??
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
            //GENERATE QR
            String fullUrl = URL_BASE + id;
            QrService.makeNewQr(fullUrl, PATH_TO_QR);
            transformer.generatePDF();
                return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @Override
    public String downloadHtml(String id){
        try {
            htmlTransformer.setINPUT_FILE("data/" + id + ".xml");
            htmlTransformer.setXSL_FILE("data/xslt-html/DigitalCert.xsl");
            String outputFileName = "DigitalCert" + id + ".html";
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
    public DigitalCertificates findAllByJmbg(String jmbg) {
        try {
            List<DigitalCertificate> certificates = repository.findAllByJmbg(jmbg);
            return new DigitalCertificates(certificates);
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DigitalCertificates findByPhrase(String phrase) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new DigitalCertificates(repository.findAllbyPhrase(phrase));
    }
}
