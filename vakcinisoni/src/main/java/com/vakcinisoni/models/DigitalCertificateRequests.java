package com.vakcinisoni.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "certificateRequests")
public class DigitalCertificateRequests {

    private List<DigitalCertificateRequest> certificateRequest;

    public DigitalCertificateRequests(){

    }
    public DigitalCertificateRequests(List<DigitalCertificateRequest> certificateRequest) {
        this.certificateRequest = certificateRequest;
    }

    public List<DigitalCertificateRequest> getCertificateRequest() {
        return certificateRequest;
    }

    public void setCertificateRequest(List<DigitalCertificateRequest> certificateRequest) {
        this.certificateRequest = certificateRequest;
    }

    @Override
    public String toString() {
        return "DigitalCertificateRequests{" +
                "certificateRequest=" + certificateRequest +
                '}';
    }
}
