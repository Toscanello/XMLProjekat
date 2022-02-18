package com.vakcinisoni.services;

import com.vakcinisoni.models.Term;
import com.vakcinisoni.models.VaccineCandidate;
import com.vakcinisoni.models.VaccineCandidates;

public interface IVaccineCandidateService {

    Term save(VaccineCandidate candidate);

    int countDistinct();

    VaccineCandidates findAllForJmbg(String jmbg);

    String download(String id);

    String downloadHtml(String id);
}
