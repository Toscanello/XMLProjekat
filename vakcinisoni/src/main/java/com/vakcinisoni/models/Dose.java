package com.vakcinisoni.models;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "type",
        "manufacturer",
        "date",
        "batch",
        "institution"
})
@XmlRootElement(name = "dose")
public class Dose {

    @XmlElement(required = true)
    protected String type;

    @XmlElement(required = true)
    protected String manufacturer;

    @XmlElement(required = true)
    protected String date;

    @XmlElement(required = true)
    protected String batch;

    @XmlElement(required = true)
    protected String institution;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
