package com.vakcinisoni.models;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "manufacturer",
})
@XmlRootElement(name = "options")
public class Options {

    @XmlElement(required = true)
    protected List<String> manufacturer;

    public List<String> getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(List<String> manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");

        for (String m : getManufacturer()) {
            builder.append("\nManufacturer: " + m);
        }

        return builder.toString();

    }
}
