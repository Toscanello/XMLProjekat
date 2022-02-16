package com.vakcinisoni.services;

import com.vakcinisoni.models.DigitalCertificateRequest;

public interface IDigitalCertificateRequestService {

    DigitalCertificateRequest save(DigitalCertificateRequest request);

    String download(String id);
}
