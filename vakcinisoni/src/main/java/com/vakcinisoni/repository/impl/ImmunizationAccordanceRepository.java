package com.vakcinisoni.repository.impl;

import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.services.DbService;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ImmunizationAccordanceRepository extends CrudRepository<ImmunizationAccordance>{
    private static final String IMMUNIZATION_ACCORDANCE_COLLECTION_NAME = "immunization-accordance";
    public ImmunizationAccordanceRepository() throws IOException{
        super(IMMUNIZATION_ACCORDANCE_COLLECTION_NAME);
    }

    @Override
    public ImmunizationAccordance save(ImmunizationAccordance entity) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        databaseUtils.createDatabaseConnection();
        org.xmldb.api.base.Collection col = null;
        try {
            col = DbService.getOrCreateCollection(collectionId);
            String id = entity.getJmbg()+"_"+entity.getDate();

            DbService.writeToDb(entity, collectionId, id);
        } finally {
            // don't forget to cleanup
            if(col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }

        return entity;
    }

    public ImmunizationAccordance findOneByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<ImmunizationAccordance> allAccordances = (ArrayList<ImmunizationAccordance>) this.findAll("/accordance");
        List<ImmunizationAccordance> newList = allAccordances.stream().filter(acc->acc.getJmbg().equals(jmbg)).collect(Collectors.toList());
        newList.sort((a1,a2)->a2.getDate().compareTo(a1.getDate()));
        if(newList.isEmpty() || newList.get(0).getVaccineEvidence().getInstitution()!=null)
            return null;
        return newList.get(0);
    }
    public ImmunizationAccordance findLastAccordance(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<ImmunizationAccordance> allAccordance = (ArrayList<ImmunizationAccordance>)this.findAll("/accordance");
        List<ImmunizationAccordance> newList = allAccordance.stream().filter(acc->(acc.getJmbg().equals(jmbg))&&(acc.getVaccineEvidence().getInstitution()!=null)).collect(Collectors.toList());
        newList.sort((a1,a2)->a2.getDate().compareTo(a1.getDate()));
        if(newList.isEmpty())
            return null;
        return newList.get(0);
    }
}
