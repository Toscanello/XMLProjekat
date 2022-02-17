package com.vakcinisoni.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "vaccineCandidates")
public class VaccineCandidates {
    private List<VaccineCandidate> vaccineCandidate;

    public VaccineCandidates(){

    }

    public VaccineCandidates(List<VaccineCandidate> vaccineCandidate) {
        this.vaccineCandidate = vaccineCandidate;
    }

    public List<VaccineCandidate> getVaccineCandidate() {
        return vaccineCandidate;
    }

    public void setVaccineCandidate(List<VaccineCandidate> vaccineCandidate) {
        this.vaccineCandidate = vaccineCandidate;
    }

    @Override
    public String toString() {
        return "VaccineCandidates{" +
                "vaccineCandidate=" + vaccineCandidate +
                '}';
    }
}
