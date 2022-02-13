package vakcinisoniclerk.models;

import javax.xml.bind.annotation.*;

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
        return "VaccineCandidate{" +
                "residence='" + residence + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", homeNum='" + homeNum + '\'' +
                ", location='" + location + '\'' +
                ", options=" + options +
                ", isBloodDonor=" + isBloodDonor +
                ", date='" + date + '\'' +
                '}';
    }


}
