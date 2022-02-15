package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.DigitalCertificate;
import com.vakcinisoni.models.DigitalCertificates;
import com.vakcinisoni.repository.impl.DigitalCertificateRepository;
import com.vakcinisoni.services.IDigitalCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

import java.util.Collection;

@Service
public class DigitalCertificateService implements IDigitalCertificateService {

    @Autowired
    public DigitalCertificateRepository repository;

    @Override
    public DigitalCertificates findAll() {
        try {
            Collection<DigitalCertificate> coll = repository.findAll("/certificate");
            return new DigitalCertificates(coll);

        } catch (XMLDBException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DigitalCertificate save(DigitalCertificate certificate) {
        try {
            return repository.save(certificate); // validations??
        } catch (XMLDBException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
