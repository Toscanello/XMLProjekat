package com.vakcinisoni.models;

import com.vakcinisoni.models.metadata.Fullname;
import com.vakcinisoni.models.metadata.Jmbg;
import org.exist.xquery.DescendantOrSelfSelector;

import javax.xml.bind.annotation.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
    @XmlAttribute(name = "xmlns:pred")
    protected String pred;

    @XmlAttribute(name = "about")
    protected String about;

    @XmlElement(required = true)
    protected Fullname fullName;

    @XmlElement(required = true)
    protected String birthDate;

    @XmlElement(required = true)
    protected String gender;

    @XmlElement(required = true)
    protected Jmbg jmbg;

    @XmlElement(required = true)
    protected Doses doses;

    @XmlElement(required = true)
    protected String institution;

    @XmlElement(required = true)
    protected String vaccine;

    @XmlElement(required = true)
    protected ConfirmationDate confirmationDate;

    @XmlElement(required = true)
    protected String qrCode;

    public VaccinationReport(){}
    public VaccinationReport(ImmunizationAccordance im){
        this.fullName.setProperty("pred:fullname");
        this.fullName.setValue(im.getName()+" "+im.getSurname());
        this.birthDate=im.getBirthDate();
        this.gender = String.valueOf(im.getGender());
        this.jmbg.setProperty("pred:jmbg");
        this.jmbg.setValue(im.getJmbg().getValue());
        this.institution = im.getVaccineEvidence().getInstitution().getValue();
        this.vaccine =im.getVaccineEvidence().getTable().getRow().get(0).getVaccineName();
        this.doses = new Doses();
        for (ImmunizationAccordance.VaccineEvidence.Table.Row row:im.getVaccineEvidence().getTable().getRow()){
            this.doses.addDose(new Dose(row.getDateIssued(),row.getBatch()));
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.confirmationDate.setProperty("pred:confiramtionDate");
        this.confirmationDate.setValue(dtf.format(LocalDateTime.now()));
        this.qrCode = "nekiqrkod";// sredi ovo posle
    }
    public String getPred(){return this.pred;}
    public void setPred(String pred){this.pred = pred;}
    public String getAbout(){return this.about;}
    public void setAbout(String about){this.about = about;}

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Jmbg getJmbg() {
        return jmbg;
    }

    public void setJmbg(Jmbg jmbg) {
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

    public ConfirmationDate getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(ConfirmationDate confirmationDate) {
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

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "confirmationDate")
    public static class ConfirmationDate{
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
