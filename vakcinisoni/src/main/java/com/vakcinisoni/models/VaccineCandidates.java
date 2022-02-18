package com.vakcinisoni.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "vaccineCandidates")
public class VaccineCandidates {
    private List<VaccineCandidateWithId> vaccineCandidate;

    public VaccineCandidates(){

    }

    public VaccineCandidates(List<VaccineCandidateWithId> vaccineCandidate) {
        this.vaccineCandidate = vaccineCandidate;
    }

    public List<VaccineCandidateWithId> getVaccineCandidate() {
        return vaccineCandidate;
    }

    public void setVaccineCandidate(List<VaccineCandidateWithId> vaccineCandidate) {
        this.vaccineCandidate = vaccineCandidate;
    }

    @Override
    public String toString() {
        return "VaccineCandidates{" +
                "vaccineCandidate=" + vaccineCandidate +
                '}';
    }
}
