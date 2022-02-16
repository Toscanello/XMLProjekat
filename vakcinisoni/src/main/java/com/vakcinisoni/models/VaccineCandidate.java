package com.vakcinisoni.models;

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
    @XmlElement(required = true)
    protected String residence;

    @XmlElement(required = true)
    protected String jmbg;

    @XmlElement(required = true)
    protected String name;

    @XmlElement(required = true)
    protected String surname;

    @XmlElement(required = true)
    protected String email;

    @XmlElement(required = true)
    protected String phoneNum;

    @XmlElement(required = true)
    protected String homeNum;

    @XmlElement(required = true)
    protected String location;

    @XmlElement(required = true)
    protected Options options;

    @XmlElement(required = true)
    protected Boolean isBloodDonor;

    @XmlElement(required = true)
    protected String date;

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
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
        retVal += "\nIme i prezime: " + name + " " + surname;
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
}
