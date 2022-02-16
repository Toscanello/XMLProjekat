package com.vakcinisoni.services;

import com.vakcinisoni.models.Accordances;
import com.vakcinisoni.models.ImmunizationAccordance;

public interface IImmunizationAccordanceService {

    ImmunizationAccordance save(ImmunizationAccordance accordance);

    Accordances findAll();

    String download(String id);
}
