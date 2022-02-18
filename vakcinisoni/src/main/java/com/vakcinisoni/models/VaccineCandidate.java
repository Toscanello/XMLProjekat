package com.vakcinisoni.models;

import com.vakcinisoni.models.metadata.Jmbg;
import com.vakcinisoni.models.metadata.Name;
import com.vakcinisoni.models.metadata.Surname;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "residence",
        "jmbg",
        "name",
        "surname",
        "email",
        "phoneNum",
        "homeNum",
        "location",
        "options",
        "isBloodDonor",
        "date"
})
@XmlRootElement(name = "vaccineCandidate")
public class VaccineCandidate {

    @XmlAttribute(name = "xmlns:pred")
    protected String pred;

    @XmlAttribute(name = "about")
    protected String about;

    @XmlElement(required = true)
    protected String residence;

    @XmlElement(required = true)
    protected Jmbg jmbg;

    @XmlElement(required = true)
    protected Name name;

    @XmlElement(required = true)
    protected Surname surname;

    @XmlElement(required = true)
    protected String email;

    @XmlElement(required = true)
    protected String phoneNum;

    @XmlElement(required = true)
    protected String homeNum;

    @XmlElement(required = true)
    protected Location location;

    @XmlElement(required = true)
    protected Options options;

    @XmlElement(required = true)
    protected Boolean isBloodDonor;

    @XmlElement(required = true)
    protected String date;

    public String getPred(){return this.pred;}
    public void setPred(String pred){this.pred = pred;}
    public String getAbout(){return this.about;}
    public void setAbout(String about){this.about = about;}

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Jmbg getJmbg() {
        return jmbg;
    }

    public void setJmbg(Jmbg jmbg) {
        this.jmbg = jmbg;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Surname getSurname() {
        return surname;
    }

    public void setSurname(Surname surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getHomeNum() {
        return homeNum;
    }

    public void setHomeNum(String homeNum) {
        this.homeNum = homeNum;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Options getOptions() {
        if(options == null) {
            options = new Options();
        }
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Boolean getBloodDonor() {
        return isBloodDonor;
    }

    public void setBloodDonor(Boolean bloodDonor) {
        isBloodDonor = bloodDonor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String retVal = "";
        retVal += getStringFromResidence(residence);
        retVal += "\nIme i prezime: " + name.getValue() + " " + surname.getValue();
        retVal += "\nBroj mobilnog: " + phoneNum;
        retVal += "\nBroj fiksnog: " + homeNum;
        retVal += "\nTipovi vakcine: " + options;
        retVal += isBloodDonor ? "\nJeste davalac krvi" : "\nNije davalac krvi";
        retVal += "\nDatum podnosenja interesovanja: " + date;
        return retVal;
    }

    private String getStringFromResidence(String residence){
        if(residence.equals("1")){
            return "Strani drzavljanin sa boravkom u RS";
        }
        else if (residence.equals("2")){
            return "Strani drzavljanin bez boravka u RS";
        }
        else {
            return "Drzavljanin Republike Srbije";
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccineCandidate that = (VaccineCandidate) o;
        return Objects.equals(jmbg, that.jmbg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jmbg);
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "location")
    public static class Location{
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
