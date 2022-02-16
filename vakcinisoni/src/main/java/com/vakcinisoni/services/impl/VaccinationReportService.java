package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.VaccinationReport;
import com.vakcinisoni.models.VaccinationReports;
import com.vakcinisoni.repository.impl.VaccinationReportRepository;
import com.vakcinisoni.services.IVaccinationReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

@Service
public class VaccinationReportService implements IVaccinationReportService {

    @Autowired
    public VaccinationReportRepository repository;

    @Override
    public VaccinationReports findAllByJmbg(String jmbg) {
        try {
            return new VaccinationReports(repository.findAllByJmbg(jmbg));
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public VaccinationReport save(VaccinationReport report) {
        try {
            return repository.save(report);
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
