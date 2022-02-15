package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.repository.impl.ImmunizationAccordanceRepository;
import com.vakcinisoni.services.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

@Service
public class MedicalService implements IMedicalService {
    @Autowired
    ImmunizationAccordanceRepository immunizationAccordanceRepository;

    @Override
    public ImmunizationAccordance findOneByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return immunizationAccordanceRepository.findOneByJmbg(jmbg);
    }
}
