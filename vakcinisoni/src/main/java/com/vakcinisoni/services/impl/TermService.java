package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.Term;
import com.vakcinisoni.repository.impl.TermRepository;
import com.vakcinisoni.services.ITermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

@Service
public class TermService implements ITermService {

    @Autowired
    public TermRepository repository;


    @Override
    public Term save(Term term) {
        try {
            return repository.save(term);
        } catch (XMLDBException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
