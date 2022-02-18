package com.vakcinisoni.services;

import com.vakcinisoni.models.VaccinationReport;
import com.vakcinisoni.models.VaccinationReports;
import org.xmldb.api.base.XMLDBException;

public interface IVaccinationReportService {

    VaccinationReports findAllByJmbg(String jmbg);

    VaccinationReport save(VaccinationReport report);

    String download(String id);

    String downloadHtml(String id);

    VaccinationReports findByPhrase(String phrase) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
