package com.vakcinisoni.repository.impl;

import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.models.VaccinationReport;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VaccinationReportRepository extends CrudRepository<VaccinationReport> {
    private static final String VACCINATION_REPORT_COLLECTION_NAME = "vaccination-reports";

    public VaccinationReportRepository() throws IOException {
        super(VACCINATION_REPORT_COLLECTION_NAME);
    }
    public VaccinationReport findOneByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<VaccinationReport> allReports = (ArrayList<VaccinationReport>) this.findAll("/vaccinationReport");
        List<VaccinationReport> newList = allReports.stream().filter(acc->acc.getJmbg().equals(jmbg)).collect(Collectors.toList());
        newList.sort((a1,a2)->a2.getConfirmationDate().compareTo(a1.getConfirmationDate()));
        if(newList.isEmpty())
            return null;
        return newList.get(0);
    }
}
