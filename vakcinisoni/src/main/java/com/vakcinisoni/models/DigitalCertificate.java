package com.vakcinisoni.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "qrCode",
        "fullName",
        "gender",
        "dateOfBirth",
        "jmbg",
        "passportNum",
        "vaccination",
        
})
@XmlRootElement(name = "certificate")
public class DigitalCertificate {

}
