package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.Accordances;
import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.repository.impl.ImmunizationAccordanceRepository;
import com.vakcinisoni.services.IImmunizationAccordanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import java.util.ArrayList;
import java.util.List;
@Service
public class ImmunizationAccordanceService implements IImmunizationAccordanceService {

    @Autowired
    public ImmunizationAccordanceRepository repository;


    @Override
    public ImmunizationAccordance save(ImmunizationAccordance accordance) {
        try {
            return repository.save(accordance);
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Accordances findAll() {
        try {
            List<ImmunizationAccordance> accordanceList = (ArrayList<ImmunizationAccordance>)repository.findAll("/accordance");
            return new Accordances(accordanceList);
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
