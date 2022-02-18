package com.vakcinisoni.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "candidate")
public class VaccineCandidateWithId {

    @XmlElement
    protected String idDocument;

    protected VaccineCandidate vaccineCandidate;

    public VaccineCandidateWithId(){

    }

    public VaccineCandidateWithId(String idDocument, VaccineCandidate vaccineCandidate) {
        this.idDocument = idDocument;
        this.vaccineCandidate = vaccineCandidate;
    }

    public String getId() {
        return idDocument;
    }

    public void setId(String idDocument) {
        this.idDocument = idDocument;
    }

    public VaccineCandidate getVaccineCandidate() {
        return vaccineCandidate;
    }

    public void setVaccineCandidate(VaccineCandidate vaccineCandidate) {
        this.vaccineCandidate = vaccineCandidate;
    }
}
