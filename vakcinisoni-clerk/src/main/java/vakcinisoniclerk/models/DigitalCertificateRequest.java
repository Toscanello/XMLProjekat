package vakcinisoniclerk.models;

import vakcinisoniclerk.models.enums.Gender;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "fullName",
        "birthDate",
        "gender",
        "jmbg",
        "passportNum",
        "reason",
        "place",
        "requestDate"
})
@XmlRootElement(name = "certificateRequest")
public class DigitalCertificateRequest {

    @XmlElement(required = true)
    protected String fullName;

    @XmlElement(required = true)
    protected String birthDate;

    @XmlElement(required = true)
    protected Gender gender;

    @XmlElement(required = true)
    protected String jmbg;

    @XmlElement(required = true)
    protected String passportNum;

    @XmlElement(required = true)
    protected String reason;

    @XmlElement(required = true)
    protected String place;

    @XmlElement(required = true)
    protected String requestDate;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }
}
