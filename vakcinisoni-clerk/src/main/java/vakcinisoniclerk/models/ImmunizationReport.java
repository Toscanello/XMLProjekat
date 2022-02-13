package vakcinisoniclerk.models;

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

    @XmlElement(required = true)
    protected String startDate;

    @XmlElement(required = true)
    protected String finishDate;

    @XmlElement(required = true)
    protected String immunizationRequests;

    @XmlElement(required = true)
    protected String certificateRequests;

    @XmlElement(required = true)
    protected String certificatesIssued;

    @XmlElement(required = true)
    protected String vaccinesTaken;

    @XmlElement(required = true)
    protected String firstTimeVaccineTaken;

    @XmlElement(required = true)
    protected Manufacturers manufacturers;

    @XmlElement(required = true)
    protected String reportDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getImmunizationRequests() {
        return immunizationRequests;
    }

    public void setImmunizationRequests(String immunizationRequests) {
        this.immunizationRequests = immunizationRequests;
    }

    public String getCertificateRequests() {
        return certificateRequests;
    }

    public void setCertificateRequests(String certificateRequests) {
        this.certificateRequests = certificateRequests;
    }

    public String getCertificatesIssued() {
        return certificatesIssued;
    }

    public void setCertificatesIssued(String certificatesIssued) {
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
