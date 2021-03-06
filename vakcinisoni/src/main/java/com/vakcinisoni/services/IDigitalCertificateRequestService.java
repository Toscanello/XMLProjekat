package com.vakcinisoni.services;

import com.vakcinisoni.models.DigitalCertificateRequest;
import com.vakcinisoni.models.DigitalCertificateRequests;
import org.xmldb.api.base.XMLDBException;

public interface IDigitalCertificateRequestService {

    DigitalCertificateRequests findAll();

    DigitalCertificateRequests findAllByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    DigitalCertificateRequest save(DigitalCertificateRequest request);

    String download(String id);

    void delete(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    
    String downloadHtml(String id);

    DigitalCertificateRequests findAllForJmbg(String jmbg);
}
