package vakcinisoniclerk.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name="certificates")
public class DigitalCertificates {

    private Collection<DigitalCertificate> certificate;

    public DigitalCertificates(){

    }
    public DigitalCertificates(Collection<DigitalCertificate> certificate) {
        this.certificate = certificate;
    }

    public Collection<DigitalCertificate> getCertificate() {
        return certificate;
    }

    public void setCertificate(Collection<DigitalCertificate> certificate) {
        this.certificate = certificate;
    }
}
