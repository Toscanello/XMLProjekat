package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.models.Term;
import com.vakcinisoni.models.VaccinationReport;
import com.vakcinisoni.repository.impl.ImmunizationAccordanceRepository;
import com.vakcinisoni.repository.impl.TermRepository;
import com.vakcinisoni.repository.impl.VaccinationReportRepository;
import com.vakcinisoni.services.IMedicalService;
import com.vakcinisoni.services.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import java.util.List;

@Service
public class MedicalService implements IMedicalService {
    @Autowired
    ImmunizationAccordanceRepository immunizationAccordanceRepository;
    @Autowired
    VaccinationReportRepository vaccinationReportRepository;
    @Autowired
    TermRepository termRepository;

    @Override
    public ImmunizationAccordance findOneByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return immunizationAccordanceRepository.findOneByJmbg(jmbg);
    }

    @Override
    public ImmunizationAccordance addVaccineEvidence(String jmbg, ImmunizationAccordance.VaccineEvidence vaccineEvidence) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ImmunizationAccordance immunizationAccordance = immunizationAccordanceRepository.findOneByJmbg(jmbg);
        ImmunizationAccordance lastImmunizationAccordance = immunizationAccordanceRepository.findLastAccordance(jmbg);
        if(immunizationAccordance != null){
            immunizationAccordance.setVaccineEvidence(vaccineEvidence);
            if(lastImmunizationAccordance!=null) {
                List<ImmunizationAccordance.VaccineEvidence.Table.Row> rows =  lastImmunizationAccordance.getVaccineEvidence().getTable().getRow();
                for(int i=0;i<rows.size();i++)
                    immunizationAccordance.getVaccineEvidence().getTable().getRow().add(i,rows.get(i));
            }
            immunizationAccordanceRepository.save(immunizationAccordance);
            VaccinationReport vaccinationReport = new VaccinationReport(immunizationAccordance);
            vaccinationReportRepository.save(vaccinationReport);
            Term term = termRepository.createTermForNewVaccination(System.currentTimeMillis(),immunizationAccordance.getCity().getValue());
            //MailerService.sendEmailForNewTerm(term,immunizationAccordance.getEmail(),immunizationAccordance.getName().getValue());
            return immunizationAccordance;
        }
        return null;
    }

    @Override
    public VaccinationReport findVaccinationReportByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return vaccinationReportRepository.findOneByJmbg(jmbg);
    }
}
