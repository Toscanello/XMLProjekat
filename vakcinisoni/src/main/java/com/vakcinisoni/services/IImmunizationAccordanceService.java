package com.vakcinisoni.services;

import com.vakcinisoni.models.Accordances;
import com.vakcinisoni.models.ImmunizationAccordance;
import org.xmldb.api.base.XMLDBException;

public interface IImmunizationAccordanceService {

    ImmunizationAccordance save(ImmunizationAccordance accordance);

    Accordances findAll();

    Accordances findAllForJmbg(String jmbg);

    String download(String id);

    String downloadHtml(String id);

    Accordances findByPhrase(String phrase) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
