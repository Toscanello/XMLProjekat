package com.vakcinisoni.models;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "startDate",
        "finishDate",
        "immunizationRequests",
        "certificateRequests",
        "certificatesIssued",
        "vaccinesTaken",
        "firstTimeVaccineTaken",
        "manufacturers",
        "reportDate"
})
@XmlRootElement(name = "immunizationReport")
public class ImmunizationReport {

    @XmlAttribute(name = "xmlns:pred")
    protected String pred;

    @XmlAttribute(name = "about")
    protected String about;

    @XmlElement(required = true)
    protected StartDate startDate;

    @XmlElement(required = true)
    protected FinishDate finishDate;

    @XmlElement(required = true)
    protected ImmunizationRequests immunizationRequests;

    @XmlElement(required = true)
    protected CertificateRequests certificateRequests;

    @XmlElement(required = true)
    protected CertificatesIssued certificatesIssued;

    @XmlElement(required = true)
    protected String vaccinesTaken;

    @XmlElement(required = true)
    protected String firstTimeVaccineTaken;

    @XmlElement(required = true)
    protected Manufacturers manufacturers;

    @XmlElement(required = true)
    protected String reportDate;

    public String getPred(){return this.pred;}
    public void setPred(String pred){this.pred = pred;}
    public String getAbout(){return this.about;}
    public void setAbout(String about){this.about = about;}

    public StartDate getStartDate() {
        return startDate;
    }

    public void setStartDate(StartDate startDate) {
        this.startDate = startDate;
    }

    public FinishDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(FinishDate finishDate) {
        this.finishDate = finishDate;
    }

    public ImmunizationRequests getImmunizationRequests() {
        return immunizationRequests;
    }

    public void setImmunizationRequests(ImmunizationRequests immunizationRequests) {
        this.immunizationRequests = immunizationRequests;
    }

    public CertificateRequests getCertificateRequests() {
        return certificateRequests;
    }

    public void setCertificateRequests(CertificateRequests certificateRequests) {
        this.certificateRequests = certificateRequests;
    }

    public CertificatesIssued getCertificatesIssued() {
        return certificatesIssued;
    }

    public void setCertificatesIssued(CertificatesIssued certificatesIssued) {
        this.certificatesIssued = certificatesIssued;
    }

    public String getVaccinesTaken() {
        return vaccinesTaken;
    }

    public void setVaccinesTaken(String vaccinesTaken) {
        this.vaccinesTaken = vaccinesTaken;
    }

    public String getFirstTimeVaccineTaken() {
        return firstTimeVaccineTaken;
    }

    public void setFirstTimeVaccineTaken(String firstTimeVaccineTaken) {
        this.firstTimeVaccineTaken = firstTimeVaccineTaken;
    }

    public Manufacturers getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Manufacturers manufacturers) {
        this.manufacturers = manufacturers;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "ImmunizationReport{" +
                "startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", immunizationRequests='" + immunizationRequests + '\'' +
                ", certificateRequests='" + certificateRequests + '\'' +
                ", certificatesIssued='" + certificatesIssued + '\'' +
                ", vaccinesTaken='" + vaccinesTaken + '\'' +
                ", firstTimeVaccineTaken='" + firstTimeVaccineTaken + '\'' +
                ", manufacturers=" + manufacturers +
                ", reportDate='" + reportDate + '\'' +
                '}';
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "startDate")
    public static class StartDate {

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
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "finishDate")
    public static class FinishDate {

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
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "immunizationRequests")
    public static class ImmunizationRequests {

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
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "certificateRequests")
    public static class CertificateRequests {

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
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "certificatesIssued")
    public static class CertificatesIssued {

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


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "manufacturer",
    })
    @XmlRootElement(name = "manufacturers")
    public static class Manufacturers {
        @XmlElement(required = true)
        protected Manufacturer manufacturer;

        public Manufacturer getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(Manufacturer manufacturer) {
            this.manufacturer = manufacturer;
        }

        @Override
        public String toString() {
            return "Manufacturers{" +
                    "manufacturer=" + manufacturer +
                    '}';
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "name",
                "numberOfVaccines"
        })
        @XmlRootElement(name = "manufacturers")
        public static class Manufacturer {
            @XmlElement(required = true)
            protected String name;

            @XmlElement(required = true)
            protected int numberOfVaccines;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNumberOfVaccines() {
                return numberOfVaccines;
            }

            public void setNumberOfVaccines(int numberOfVaccines) {
                this.numberOfVaccines = numberOfVaccines;
            }

            @Override
            public String toString() {
                return "Manufacturer{" +
                        "name='" + name + '\'' +
                        ", numberOfVaccines=" + numberOfVaccines +
                        '}';
            }
        }
    }

}
