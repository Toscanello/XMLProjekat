package com.vakcinisoni.models.metadata;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "jmbg")
public class Jmbg {

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
