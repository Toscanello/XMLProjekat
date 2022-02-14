package com.vakcinisoni.repository.impl;


import com.vakcinisoni.models.Citizen;
import com.vakcinisoni.services.DbService;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
@Component
public class CitizenRepository extends CrudRepository<Citizen>{

    private static final String CITIZEN_COLLECTION_NAME = "citizens";

    public CitizenRepository() throws IOException {
        super(CITIZEN_COLLECTION_NAME);
    }

    @Override
    public Citizen save(Citizen entity) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        databaseUtils.createDatabaseConnection();

        org.xmldb.api.base.Collection col = null;

        try {
            DbService.writeToDb(entity, collectionId, entity.getJmbg());
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

}
