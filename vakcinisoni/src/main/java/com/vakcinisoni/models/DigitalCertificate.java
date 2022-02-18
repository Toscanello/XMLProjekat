package com.vakcinisoni.models;

import com.vakcinisoni.models.enums.Gender;
import com.vakcinisoni.models.metadata.Fullname;
import com.vakcinisoni.models.metadata.Jmbg;

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

    @XmlAttribute(name = "xmlns:pred")
    protected String pred;

    @XmlAttribute(name = "about")
    protected String about;
    @XmlAttribute(name = "dateTime")
    protected String dateTime;

    @XmlElement(required = true)
    protected String id;

    @XmlElement(required = true)
    protected String qrCode;

    @XmlElement(required = true)
    protected Fullname fullName;

    @XmlElement(required = true)
    protected Gender gender;

    @XmlElement(required = true)
    protected String dateOfBirth;

    @XmlElement(required = true)
    protected Jmbg jmbg;

    @XmlElement(required = true)
    protected String passportNum;

    @XmlElement(required = true)
    protected Vaccination vaccination;

    public String getPred(){return this.pred;}
    public void setPred(String pred){this.pred = pred;}
    public String getAbout(){return this.about;}
    public void setAbout(String about){this.about = about;}
    public String getDateTime(){return this.dateTime;}
    public void setDateTime(String dateTime){this.dateTime = dateTime;}

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

    public Fullname getFullName() {
        return fullName;
    }

    public void setFullName(Fullname fullName) {
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

    public Jmbg getJmbg() {
        return jmbg;
    }

    public void setJmbg(Jmbg jmbg) {
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
