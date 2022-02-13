package vakcinisoniclerk.models.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "certificate-declined")
public class DeclineCertificateRequestDto {

    @XmlElement
    private String declineMessage;

    public DeclineCertificateRequestDto() {}

    public DeclineCertificateRequestDto(String message) {
        this.declineMessage = message;
    }

    public String getMessage() {
        return declineMessage;
    }

    public void setMessage(String message) {
        this.declineMessage = message;
    }
}
