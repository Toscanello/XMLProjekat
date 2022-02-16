package com.vakcinisoni.services;

import com.vakcinisoni.models.ImmunizationAccordance;
import org.xmldb.api.base.XMLDBException;

public interface IMedicalService{

    ImmunizationAccordance findOneByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    ImmunizationAccordance addVaccineEvidence(String jmbg, ImmunizationAccordance.VaccineEvidence vaccineEvidence) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
