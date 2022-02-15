package com.vakcinisoni.models;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "dose",
})
@XmlRootElement(name = "doses")
public class Doses {

    @XmlElement(required = true)
    protected List<Dose> dose;

    public Doses(){
        this.dose = new ArrayList<>();
    }

    public List<Dose> getDose() {
        return this.dose;
    }

    public void addDose(Dose d){
        this.dose.add(d);
    }
}
