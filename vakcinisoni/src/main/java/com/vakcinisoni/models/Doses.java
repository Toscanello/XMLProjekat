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

    public List<Dose> getDose() {
        if (dose == null)
            dose = new ArrayList<Dose>();

        return this.dose;
    }
}
