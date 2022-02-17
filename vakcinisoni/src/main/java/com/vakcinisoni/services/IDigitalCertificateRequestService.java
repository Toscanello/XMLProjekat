package com.vakcinisoni.services;

import com.vakcinisoni.models.DigitalCertificateRequest;
import com.vakcinisoni.models.DigitalCertificateRequests;

public interface IDigitalCertificateRequestService {

    DigitalCertificateRequest save(DigitalCertificateRequest request);

    String download(String id);

    String downloadHtml(String id);

    DigitalCertificateRequests findAllForJmbg(String jmbg);
}
