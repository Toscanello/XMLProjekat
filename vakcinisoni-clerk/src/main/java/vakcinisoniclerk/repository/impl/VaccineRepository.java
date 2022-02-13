package vakcinisoniclerk.repository.impl;

import org.xmldb.api.base.XMLDBException;
import vakcinisoniclerk.models.Vaccine;
import vakcinisoniclerk.repository.ICrudRepository;
import vakcinisoniclerk.services.DbService;

import java.io.IOException;
import java.util.Collection;

public class VaccineRepository extends CrudRepository<Vaccine> {

    private static final String VACCINES_COLLECTION_NAME = "vaccines";

    public VaccineRepository() throws IOException {
        super(VACCINES_COLLECTION_NAME);
    }

    @Override
    public Collection<Vaccine> findAll() throws XMLDBException, ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        return super.findAll();
    }

    @Override
    public Vaccine save(Vaccine vaccine) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        org.xmldb.api.base.Collection col = null;

        col = DbService.getOrCreateCollection(collectionId);
        long id = col.getResourceCount() + 1;
        vaccine.setId(id);

        return super.save(vaccine);
    }
}
