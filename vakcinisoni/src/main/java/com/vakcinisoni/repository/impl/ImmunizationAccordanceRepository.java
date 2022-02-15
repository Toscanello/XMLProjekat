package com.vakcinisoni.repository.impl;

import com.vakcinisoni.models.ImmunizationAccordance;
import org.checkerframework.common.util.report.qual.ReportCreation;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ImmunizationAccordanceRepository extends CrudRepository<ImmunizationAccordance>{
    private static final String IMMUNIZATION_ACCORDANCE_COLLECTION_NAME = "immunization-accordance";
    public ImmunizationAccordanceRepository() throws IOException {
        super(IMMUNIZATION_ACCORDANCE_COLLECTION_NAME);
    }
    public ImmunizationAccordance findOneByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<ImmunizationAccordance> allAccordances = (ArrayList<ImmunizationAccordance>) this.findAll("/accordance");
        List<ImmunizationAccordance> newList = allAccordances.stream().filter(acc->acc.getJmbg().equals(jmbg)).collect(Collectors.toList());
        newList.sort((a1,a2)->a2.getDate().compareTo(a1.getDate()));
        return newList.get(0);
    }
}
