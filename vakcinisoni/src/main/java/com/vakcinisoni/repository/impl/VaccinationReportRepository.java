package com.vakcinisoni.repository.impl;

import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.models.VaccinationReport;
import com.vakcinisoni.models.VaccinationReports;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class VaccinationReportRepository extends CrudRepository<VaccinationReport> {
    private static final String VACCINATION_REPORT_COLLECTION_NAME = "vaccination-reports";

    public VaccinationReportRepository() throws IOException {
        super(VACCINATION_REPORT_COLLECTION_NAME);
    }
    public VaccinationReport findOneByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<VaccinationReport> allReports = (ArrayList<VaccinationReport>) this.findAll("/vaccinationReport");
        List<VaccinationReport> newList = allReports.stream().filter(acc->acc.getJmbg().getValue().equals(jmbg)).collect(Collectors.toList());
        newList.sort((a1,a2)->a2.getConfirmationDate().getValue().compareTo(a1.getConfirmationDate().getValue()));
        if(newList.isEmpty())
            return null;
        return newList.get(0);
    }

    public List<VaccinationReport> findAllByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<VaccinationReport> allReports = (ArrayList<VaccinationReport>) this.findAll("/vaccinationReport");
        List<VaccinationReport> newList = allReports.stream().filter(acc->acc.getJmbg().getValue().equals(jmbg)).collect(Collectors.toList());
        System.out.println("NASAO JE -> " + newList.size() + "  ZA JMBG: " + jmbg );
        return newList;
    }

    public List<VaccinationReport> findAllByPhrase(String phrase) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<VaccinationReport> allReports = (ArrayList<VaccinationReport>) this.findAll("/vaccinationReport");
        String finalPhrase = phrase.toLowerCase();
        List<VaccinationReport> newList = allReports.stream()
                .filter(vacc -> vacc.getFullName().getValue().toLowerCase().contains(finalPhrase)
                        || vacc.getBirthDate().toLowerCase().contains(finalPhrase)
                        || vacc.getJmbg().getValue().toLowerCase().contains(finalPhrase)
                        || vacc.getInstitution().toLowerCase().contains(finalPhrase)
                        || vacc.getVaccine().toLowerCase().contains(finalPhrase)
                        || vacc.getConfirmationDate().getValue().contains(finalPhrase)
                        || vacc.getDoses().getDose().stream().anyMatch(d->d.getBatch().equals(finalPhrase))
                        || vacc.getDoses().getDose().stream().anyMatch(d->d.getDate().equals(finalPhrase))
                )
                .collect(Collectors.toList());
        return newList;
    }
}
