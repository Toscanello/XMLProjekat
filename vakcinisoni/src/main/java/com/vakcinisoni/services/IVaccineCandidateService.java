package com.vakcinisoni.services;

import com.vakcinisoni.models.Term;
import com.vakcinisoni.models.VaccineCandidate;

public interface IVaccineCandidateService {

    Term save(VaccineCandidate candidate);

    int countDistinct();

}
