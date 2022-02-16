package com.vakcinisoni.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name="certificate-requests")
public class DigitalCertificateRequests {

    private Collection<DigitalCertificateRequest> certificateRequest;

    public DigitalCertificateRequests() {
    }

    public DigitalCertificateRequests(Collection<DigitalCertificateRequest> certificateRequest) {
        this.certificateRequest = certificateRequest;
    }

    public Collection<DigitalCertificateRequest> getCertificateRequest() {
        return certificateRequest;
    }

    public void setCertificateRequest(Collection<DigitalCertificateRequest> certificateRequest) {
        this.certificateRequest = certificateRequest;
    }
}
