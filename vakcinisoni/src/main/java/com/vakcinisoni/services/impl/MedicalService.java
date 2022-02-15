package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.repository.impl.ImmunizationAccordanceRepository;
import com.vakcinisoni.services.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import java.util.List;

@Service
public class MedicalService implements IMedicalService {
    @Autowired
    ImmunizationAccordanceRepository immunizationAccordanceRepository;

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
            return immunizationAccordance;
        }
        return null;
    }
}
