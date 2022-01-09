package com.vakcinisoni.models;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "title",
        "author",
        "year",
        "price"
})
@XmlRootElement(name = "vaccination")
public class Vaccination {

    @XmlElement(required = true)
    protected List<Dose> dose;

    public List<Dose> getDose() {
        return dose;
    }

    public void setDose(List<Dose> dose) {
        this.dose = dose;
    }
}
