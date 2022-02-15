package com.vakcinisoni.repository.impl;

import com.vakcinisoni.models.VaccineCandidate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class VaccineCandidateRepository extends CrudRepository<VaccineCandidate>{

    private static final String VACCINE_CANDIDATE_COLLECTION_NAME = "vaccine-candidates";

    public VaccineCandidateRepository() throws IOException {
        super(VACCINE_CANDIDATE_COLLECTION_NAME);
    }

}
