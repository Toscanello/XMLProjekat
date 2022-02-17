package com.vakcinisoni.models;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "jmbg",
        "surname",
        "name",
        "parentName",
        "gender",
        "birthDate",
        "birthPlace",
        "address",
        "post",
        "city",
        "homeNumber",
        "phoneNum",
        "email",
        "workStatus",
        "employedAt",
        "socialSecurity",
        "residenceName",
        "isAccordant",
        "medicineName",
        "date",
        "vaccineEvidence"
})
@XmlRootElement(name = "accordance")
public class ImmunizationAccordance {

    @XmlAttribute(name = "xmlns:pred")
    protected String pred;
    @XmlAttribute(name = "about")
    protected String about;

    @XmlElement(required = true)
    protected String jmbg;

    @XmlElement(required = true)
    protected String surname;

    @XmlElement(required = true)
    protected String name;

    @XmlElement(required = true)
    protected String parentName;

    @XmlElement(required = true)
    protected int gender;

    @XmlElement(required = true)
    protected String birthDate;

    @XmlElement(required = true)
    protected String birthPlace;

    @XmlElement(required = true)
    protected String address;

    @XmlElement(required = true)
    protected String post;

    @XmlElement(required = true)
    protected City city;

    @XmlElement(required = true)
    protected String homeNumber;

    @XmlElement(required = true)
    protected String phoneNum;

    @XmlElement(required = true)
    protected String email;

    @XmlElement(required = true)
    protected int workStatus;

    @XmlElement(required = true)
    protected int employedAt;

    @XmlElement(required = true)
    protected Boolean socialSecurity;

    @XmlElement(required = true)
    protected String residenceName;

    @XmlElement(required = true)
    protected Boolean isAccordant;

    @XmlElement(required = true)
    protected String medicineName;

    @XmlElement(required = true)
    protected String date;

    @XmlElement(required = true)
    protected VaccineEvidence vaccineEvidence;

    public String getPred(){return this.pred;}
    public void setPred(String pred){this.pred = pred;}
    public String getAbout(){return this.about;}
    public void setAbout(String about){this.about = about;}

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(int workStatus) {
        this.workStatus = workStatus;
    }

    public int getEmployedAt() {
        return employedAt;
    }

    public void setEmployedAt(int employedAt) {
        this.employedAt = employedAt;
    }

    public Boolean getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(Boolean socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public void setResidenceName(String residenceName) {
        this.residenceName = residenceName;
    }

    public Boolean getAccordant() {
        return isAccordant;
    }

    public void setAccordant(Boolean accordant) {
        isAccordant = accordant;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public VaccineEvidence getVaccineEvidence() {
        if (vaccineEvidence == null) {
            vaccineEvidence = new VaccineEvidence();
        }
        return vaccineEvidence;
    }

    public void setVaccineEvidence(VaccineEvidence vaccineEvidence) {
        this.vaccineEvidence = vaccineEvidence;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "city")
    public static class City {

        @XmlAttribute(name = "property")
        private String property;
        @XmlValue
        private String value;

        public String getProperty(){return this.property;}
        public void setProperty(String property){this.property=property;}
        public String getValue(){return this.value;}
        public void setValue(String value){this.value=value;}

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "institution",
            "vaccinationNum",
            "doctorInfo",
            "table"
    })
    @XmlRootElement(name = "vaccineEvidence")
    public static class VaccineEvidence {

        @XmlElement(required = true)
        protected String institution;
        @XmlElement(required = true)
        protected String vaccinationNum;
        @XmlElement(required = true)
        protected DoctorInfo doctorInfo;
        @XmlElement(required = true)
        protected Table table;

        public String getInstitution() {
            return institution;
        }

        public void setInstitution(String institution) {
            this.institution = institution;
        }

        public String getVaccinationNum() {
            return vaccinationNum;
        }

        public void setVaccinationNum(String vaccinationNum) {
            this.vaccinationNum = vaccinationNum;
        }

        public DoctorInfo getDoctorInfo() {
            if (doctorInfo == null) {
                doctorInfo = new DoctorInfo();
            }
            return doctorInfo;
        }

        public void setDoctorInfo(DoctorInfo doctorInfo) {
            this.doctorInfo = doctorInfo;
        }

        public Table getTable() {
            if (table == null) {
                table = new Table();
            }
            return table;
        }

        public void setTable(Table table) {
            this.table = table;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "fullName",
                "fax",
                "phoneNum",
        })
        @XmlRootElement(name = "doctorInfo")
        public static class DoctorInfo {

            @XmlElement(required = true)
            protected String fullName;
            @XmlElement(required = true)
            protected String fax;
            @XmlElement(required = true)
            protected String phoneNum;

            public String getFullName() {
                return fullName;
            }

            public void setFullName(String fullName) {
                this.fullName = fullName;
            }

            public String getFax() {
                return fax;
            }

            public void setFax(String fax) {
                this.fax = fax;
            }

            public String getPhoneNum() {
                return phoneNum;
            }

            public void setPhoneNum(String phoneNum) {
                this.phoneNum = phoneNum;
            }

            @Override
            public String toString() {
                return "DoctorInfo{" +
                        "fullName='" + fullName + '\'' +
                        ", fax='" + fax + '\'' +
                        ", phoneNum='" + phoneNum + '\'' +
                        '}';
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "row",
        })
        @XmlRootElement(name = "table")
        public static class Table {

            @XmlElement(required = true)
            protected List<Row> row;

            public List<Row> getRow() {
                if (row == null) {
                    row = new ArrayList<>();
                }
                return row;
            }

            public void setRow(List<Row> row) {
                this.row = row;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "vaccineName",
                    "dateIssued",
                    "issueMethod",
                    "bodyPart",
                    "batch",
                    "manufacturer",
                    "reaction",
            })
            @XmlRootElement(name = "row")
            public static class Row {

                @XmlElement(required = true)
                protected String vaccineName;
                @XmlElement(required = true)
                protected String dateIssued;
                @XmlElement(required = true)
                protected int issueMethod;
                @XmlElement(required = true)
                protected int bodyPart;
                @XmlElement(required = true)
                protected String batch;
                @XmlElement(required = true)
                protected String manufacturer;
                @XmlElement(required = true)
                protected String reaction;

                public String getVaccineName() {
                    return vaccineName;
                }

                public void setVaccineName(String vaccineName) {
                    this.vaccineName = vaccineName;
                }

                public String getDateIssued() {
                    return dateIssued;
                }

                public void setDateIssued(String dateIssued) {
                    this.dateIssued = dateIssued;
                }

                public int getIssueMethod() {
                    return issueMethod;
                }

                public void setIssueMethod(int issueMethod) {
                    this.issueMethod = issueMethod;
                }

                public int getBodyPart() {
                    return bodyPart;
                }

                public void setBodyPart(int bodyPart) {
                    this.bodyPart = bodyPart;
                }

                public String getBatch() {
                    return batch;
                }

                public void setBatch(String batch) {
                    this.batch = batch;
                }

                public String getManufacturer() {
                    return manufacturer;
                }

                public void setManufacturer(String manufacturer) {
                    this.manufacturer = manufacturer;
                }

                public String getReaction() {
                    return reaction;
                }

                public void setReaction(String reaction) {
                    this.reaction = reaction;
                }

                @Override
                public String toString() {
                    return "Row{" +
                            "vaccineName='" + vaccineName + '\'' +
                            ", dateIssued='" + dateIssued + '\'' +
                            ", issueMethod=" + issueMethod +
                            ", bodyPart=" + bodyPart +
                            ", batch='" + batch + '\'' +
                            ", manufacturer='" + manufacturer + '\'' +
                            ", reaction='" + reaction + '\'' +
                            '}';
                }
            }
        }
    }




}


