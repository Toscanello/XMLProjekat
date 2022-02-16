package com.vakcinisoni.services;

import com.vakcinisoni.models.DigitalCertificateRequest;
import com.vakcinisoni.models.DigitalCertificateRequests;

public interface IDigitalCertificateRequestService {

    DigitalCertificateRequests findAll();

    DigitalCertificateRequest save(DigitalCertificateRequest request);

    String download(String id);
}
