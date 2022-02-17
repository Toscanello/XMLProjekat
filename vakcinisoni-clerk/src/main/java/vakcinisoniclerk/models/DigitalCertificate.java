package vakcinisoniclerk.models;

import vakcinisoniclerk.models.enums.Gender;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "qrCode",
        "fullName",
        "gender",
        "dateOfBirth",
        "jmbg",
        "passportNum",
        "vaccination"
})
@XmlRootElement(name = "certificate")
public class DigitalCertificate {

    @XmlElement(required = true)
    protected String id;

    @XmlElement(required = true)
    protected String qrCode;

    @XmlElement(required = true)
    protected String fullName;

    @XmlElement(required = true)
    protected Gender gender;

    @XmlElement(required = true)
    protected String dateOfBirth;

    @XmlElement(required = true)
    protected String jmbg;

    @XmlElement(required = true)
    protected String passportNum;

    @XmlElement(required = true)
    protected Vaccination vaccination;

    public DigitalCertificate() {}

    public DigitalCertificate(String id, String qrCode, String fullName, Gender gender, String dateOfBirth, String jmbg, String passportNum, Vaccination vaccination) {
        this.id = id;
        this.qrCode = qrCode;
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.jmbg = jmbg;
        this.passportNum = passportNum;
        this.vaccination = vaccination;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public Vaccination getVaccination() {
        return vaccination;
    }

    public void setVaccination(Vaccination vaccination) {
        this.vaccination = vaccination;
    }
}
