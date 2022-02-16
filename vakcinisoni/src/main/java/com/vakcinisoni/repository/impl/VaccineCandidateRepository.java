package com.vakcinisoni.repository.impl;

import com.vakcinisoni.models.VaccineCandidate;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class VaccineCandidateRepository extends CrudRepository<VaccineCandidate>{

    private static final String VACCINE_CANDIDATE_COLLECTION_NAME = "vaccine-candidates";

    public VaccineCandidateRepository() throws IOException {
        super(VACCINE_CANDIDATE_COLLECTION_NAME);
    }

    public int countDistinct() throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Collection<VaccineCandidate> all = findAll("/vaccineCandidate");
        List<VaccineCandidate> distinct = new ArrayList<>();

        for(VaccineCandidate vc : all){
            if(!distinct.contains(vc)){
                distinct.add(vc);
            }
        }
        return distinct.size();
    }

}
