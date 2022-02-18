package com.vakcinisoni.models;

import com.vakcinisoni.models.enums.Gender;
import com.vakcinisoni.models.metadata.Fullname;
import com.vakcinisoni.models.metadata.Jmbg;

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

    @XmlAttribute(name = "xmlns:pred")
    protected String pred;

    @XmlAttribute(name = "about")
    protected String about;
    @XmlAttribute(name = "dateTime")
    protected String dateTime;
    @XmlAttribute(name = "accepted")
    protected String accepted;

    @XmlElement(required = true)
    protected Fullname fullName;

    @XmlElement(required = true)
    protected String birthDate;

    @XmlElement(required = true)
    protected Gender gender;

    @XmlElement(required = true)
    protected Jmbg jmbg;

    @XmlElement(required = true)
    protected String passportNum;

    @XmlElement(required = true)
    protected String reason;

    @XmlElement(required = true)
    protected Place place;

    @XmlElement(required = true)
    protected String requestDate;

    public String getPred(){return this.pred;}
    public void setPred(String pred){this.pred = pred;}
    public String getAbout(){return this.about;}
    public void setAbout(String about){this.about = about;}
    public String getDateTime(){return this.dateTime;}
    public void setDateTime(String dateTime){this.dateTime = dateTime;}
    public String getAccepted(){return this.accepted;}
    public void setAccepted(String accepted){this.accepted = accepted;}

    public Fullname getFullName() {
        return fullName;
    }

    public void setFullName(Fullname fullName) {
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "place")
    public static class Place{
        @XmlAttribute(name = "property")
        private String property;
        @XmlValue
        private String value;

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
