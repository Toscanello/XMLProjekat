package com.vakcinisoni.services;

import com.vakcinisoni.models.DigitalCertificate;
import com.vakcinisoni.models.DigitalCertificates;

public interface IDigitalCertificateService {

    DigitalCertificates findAll();

    DigitalCertificate save(DigitalCertificate certificate);

    String download(String id);

    String downloadHtml(String id);

    DigitalCertificates findAllByJmbg(String jmbg);
}
