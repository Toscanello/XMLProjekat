package com.vakcinisoni.models;

import org.exist.xquery.DescendantOrSelfSelector;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "fullName",
        "birthDate",
        "gender",
        "jmbg",
        "doses",
        "institution",
        "vaccine",
        "confirmationDate",
        "qrCode"
})
@XmlRootElement(name = "vaccinationReport")
public class VaccinationReport {
    @XmlElement(required = true)
    protected String fullName;

    @XmlElement(required = true)
    protected String birthDate;

    @XmlElement(required = true)
    protected String gender;

    @XmlElement(required = true)
    protected String jmbg;

    @XmlElement(required = true)
    protected Doses doses;

    @XmlElement(required = true)
    protected String institution;

    @XmlElement(required = true)
    protected String vaccine;

    @XmlElement(required = true)
    protected String confirmationDate;

    @XmlElement(required = true)
    protected String qrCode;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Doses getDoses() {
        return doses;
    }

    public void setDoses(Doses doses) {
        this.doses = doses;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(String confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public String toString() {
        return "VaccinationReport{" +
                "fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender='" + gender + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", doses=" + doses +
                ", institution='" + institution + '\'' +
                ", vaccine='" + vaccine + '\'' +
                ", confirmationDate='" + confirmationDate + '\'' +
                ", qrCode='" + qrCode + '\'' +
                '}';
    }
}
