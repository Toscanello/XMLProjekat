package vakcinisoniclerk.services.impl;

import org.springframework.stereotype.Service;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XPathQueryService;
import org.xmldb.api.modules.XUpdateQueryService;
import vakcinisoniclerk.models.Vaccine;
import vakcinisoniclerk.models.Vaccines;
import vakcinisoniclerk.repository.impl.VaccineRepository;
import vakcinisoniclerk.services.IVaccinesService;
import vakcinisoniclerk.util.AuthenticationUtilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static vakcinisoniclerk.models.template.XUpdateTemplate.*;

@Service
public class VaccinesServiceImpl implements IVaccinesService {

    AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

    private static final String VACCINES_COLLECTION_NAME = "vaccines";

    private VaccineRepository vaccineRepository = new VaccineRepository();

    public VaccinesServiceImpl() throws IOException {
    }

    public Vaccines getAllVaccines() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        List<Vaccine> allVaccines = (ArrayList<Vaccine>) vaccineRepository.findAll("/vaccine");
        return new Vaccines(allVaccines);
    }
    public Vaccine createNewVaccine(Vaccine vaccine) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO: throw custom exception
        return vaccineRepository.save(vaccine);
    }

    public Vaccine updateVaccineQuantity(String id, int quantity)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        String xPathSelector = "/vaccine[id='" + id + "']/quantity";
        String newQuantity = quantity + "";

        vaccineRepository.update(id, xPathSelector, newQuantity);
        return null;
    }

    public String decrementQuantityByOne(String id)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        String collectionId = "/db/sample/clerk/" + VACCINES_COLLECTION_NAME;
        String documentId = id + ".xml";

        Class<?> cl = Class.forName(conn.driver);
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        Collection col = null;

        try {
            col = DatabaseManager.getCollection(conn.uri + collectionId, conn.user, conn.password);
            XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xpathService.setProperty("indent", "yes");

            // make the service aware of namespaces, using the default one
            xpathService.setNamespace("", TARGET_NAMESPACE);

            String xpathExp = "/vaccine[id='" + id + "']/quantity/text()";
            ResourceSet result = xpathService.query(xpathExp);
            String oldQuantityS = (String) result.getResource(0).getContent();
            int oldQuantity = Integer.parseInt(oldQuantityS);
            if (oldQuantity == 0) {
                return "Error: There are 0 vaccines in the inventory.";
            }

            int newQuantity = oldQuantity - 1;

            String xqueryPath = "/vaccine[id='" + id + "']/quantity";

            XUpdateQueryService xupdateService = (XUpdateQueryService) col.getService("XUpdateQueryService", "1.0");
            xupdateService.setProperty("indent", "yes");
            xupdateService.updateResource(documentId, String.format(UPDATE, xqueryPath, newQuantity + ""));

            System.out.println("[INFO] Finished updating vaccine entity");
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
        return "Decremented vaccines inventory number by 1";
    }

    public String deleteVaccine(Long id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        vaccineRepository.delete(id);
        return "Deleted";
    }

    public Vaccine findOneVaccine(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        return vaccineRepository.findOne(id);
    }
}
