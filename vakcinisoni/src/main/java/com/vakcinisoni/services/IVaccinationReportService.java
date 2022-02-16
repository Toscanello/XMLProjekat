package com.vakcinisoni.services;

import com.vakcinisoni.models.VaccinationReport;
import com.vakcinisoni.models.VaccinationReports;

public interface IVaccinationReportService {

    VaccinationReports findAllByJmbg(String jmbg);

    VaccinationReport save(VaccinationReport report);
}
