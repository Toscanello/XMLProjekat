package com.vakcinisoni.models;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "date",
        "batch",
})
@XmlRootElement(name = "dose")
public class Dose {

    @XmlElement(required = true)
    protected String date;

    @XmlElement(required = true)
    protected String batch;

    public Dose(){}
    public Dose(String date,String batch){
        this.date = date;
        this.batch = batch;
    }

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
}
