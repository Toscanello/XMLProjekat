package com.vakcinisoni.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="certificates")
public class DigitalCertificates {

    private List<DigitalCertificate> certificate;

    public DigitalCertificates(){

    }
    public DigitalCertificates(List<DigitalCertificate> certificate) {
        this.certificate = certificate;
    }

    public List<DigitalCertificate> getCertificate() {
        return certificate;
    }

    public void setCertificate(List<DigitalCertificate> certificate) {
        this.certificate = certificate;
    }
}
