package com.vakcinisoni.repository.impl;

import com.vakcinisoni.models.DigitalCertificate;
import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.services.DbService;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class DigitalCertificateRepository extends CrudRepository<DigitalCertificate>{

    private static final String DIGITAL_CERTIFICATE_COLLECTION_NAME = "certificates";

    public DigitalCertificateRepository() throws IOException {
        super(DIGITAL_CERTIFICATE_COLLECTION_NAME);
    }

    @Override
    public Collection<DigitalCertificate> findAll(String exp) throws XMLDBException, ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        return super.findAll(exp);
    }

    @Override
    public DigitalCertificate save(DigitalCertificate certificate) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        org.xmldb.api.base.Collection col = null;

        col = DbService.getOrCreateCollection(collectionId);
        long id = col.getResourceCount() + 1;
        certificate.setId(id + "");

        return super.save(certificate);
    }

    public List<DigitalCertificate> findAllByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<DigitalCertificate> all = (ArrayList<DigitalCertificate>) this.findAll("/certificate");

        List<DigitalCertificate> retVal = all.stream()
                .filter(cert -> cert.getJmbg().getValue().equals(jmbg)).collect(Collectors.toList());
        return retVal;
    }

    public List<DigitalCertificate> findAllbyPhrase(String phrase) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<DigitalCertificate> allReports = (ArrayList<DigitalCertificate>) this.findAll("/certificate");
        String finalPhrase = phrase.toLowerCase();
        List<DigitalCertificate> newList = allReports.stream()
                .filter(vacc -> vacc.getId().toLowerCase().contains(finalPhrase)
                        || vacc.getFullName().getValue().contains(finalPhrase)
                        || vacc.getDateOfBirth().contains(finalPhrase)
                        || vacc.getJmbg().getValue().contains(finalPhrase)
                        || vacc.getPassportNum().contains(finalPhrase)
                        || vacc.getVaccination().getDose().stream().anyMatch(d->d.getType().contains(finalPhrase))
                        || vacc.getVaccination().getDose().stream().anyMatch(d->d.getManufacturer().contains(finalPhrase))
                        || vacc.getVaccination().getDose().stream().anyMatch(d->d.getDate().contains(finalPhrase))
                        || vacc.getVaccination().getDose().stream().anyMatch(d->d.getBatch().contains(finalPhrase))
                        || vacc.getVaccination().getDose().stream().anyMatch(d->d.getInstitution().contains(finalPhrase))
                ).collect(Collectors.toList());
        return newList;
    }
}
