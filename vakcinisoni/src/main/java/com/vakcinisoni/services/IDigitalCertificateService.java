package com.vakcinisoni.services;

import com.vakcinisoni.models.DigitalCertificate;
import com.vakcinisoni.models.DigitalCertificates;
import org.xmldb.api.base.XMLDBException;

public interface IDigitalCertificateService {

    DigitalCertificates findAll();

    DigitalCertificate save(DigitalCertificate certificate);

    String download(String id);

    String downloadHtml(String id);

    DigitalCertificates findAllByJmbg(String jmbg);

    DigitalCertificates findByPhrase(String phrase) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
