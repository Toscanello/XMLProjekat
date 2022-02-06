package vakcinisoniclerk.services;

import org.checkerframework.checker.units.qual.C;
import org.exist.xmldb.EXistResource;
import org.springframework.stereotype.Service;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;
import org.xmldb.api.modules.XUpdateQueryService;
import vakcinisoniclerk.models.Vaccine;
import vakcinisoniclerk.models.constants.Constants;
import vakcinisoniclerk.util.AuthenticationUtilities;
import vakcinisoniclerk.util.ObjectParser;

import javax.ws.rs.*;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static vakcinisoniclerk.models.template.XUpdateTemplate.*;

@Service
@Path("/vaccines")
public class VaccinesServiceImpl {

    AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

    private static final String VACCINES_COLLECTION_NAME = "vaccines";

    public VaccinesServiceImpl() throws IOException {
    }

    @GET
    @Path("/")
    @Produces("application/xml")
    public List<Vaccine> getAllVaccines() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        List<Vaccine> vaccines = new ArrayList<>();
        String collectionId = "/db/sample/clerk/" + VACCINES_COLLECTION_NAME;

        Class<?> cl = Class.forName(conn.driver);
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        Collection col = null;

        try {
            col = DatabaseManager.getCollection(conn.uri + collectionId);

            // get an instance of xpath query service
            XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xpathService.setProperty("indent", "yes");
            // make the service aware of namespaces, using the default one
            xpathService.setNamespace("", TARGET_NAMESPACE);

            String xpathExp = "/vaccine";
            ResourceSet result = xpathService.query(xpathExp);
            ResourceIterator i = result.getIterator();
            Resource res = null;

            while(i.hasMoreResources()) {

                try {
                    res = i.nextResource();
                    Vaccine v = (Vaccine) ObjectParser.parseToObject((XMLResource) res, Constants.PATH_TO_MODELS);
                    vaccines.add(v);
                } catch (JAXBException e) {
                    e.printStackTrace();
                } finally {
                    // don't forget to cleanup resources
                    try {
                        ((EXistResource)res).freeResources();
                    } catch (XMLDBException xe) {
                        xe.printStackTrace();
                    }
                }
            }
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
        return vaccines;
    }

    @POST
    @Path("/")
    @Consumes("application/xml")
    public Vaccine createNewVaccine(Vaccine vaccine) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String collectionId = "/db/sample/clerk/" + VACCINES_COLLECTION_NAME;

        Class<?> cl = Class.forName(conn.driver);
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        Collection col = null;

        try {
            col = DbService.getOrCreateCollection(collectionId);
            long id = col.getResourceCount() + 1;
            vaccine.setId(id);

            DbService.writeToDb(vaccine, VACCINES_COLLECTION_NAME, id + "");
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

        return vaccine;
    }

    @PUT
    @Path("/{id}/quantity")
    @Consumes("application/xml")
    public Vaccine updateVaccineQuantity(@PathParam("id") String id, @QueryParam("quantity") int quantity)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        String collectionId = "/db/sample/clerk/" + VACCINES_COLLECTION_NAME;
        String documentId = id + ".xml";

        Class<?> cl = Class.forName(conn.driver);
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        Collection col = null;

        try {
            // defining xpath context
            String vaccineToUpdate = "/vaccine[id='" + id + "']";
            System.out.println("[INFO] Updating vaccine path -> " + vaccineToUpdate);
            String quantityPath = vaccineToUpdate + "/quantity";

            String newQuantity = quantity + "";

            // get the collection
            col = DatabaseManager.getCollection(conn.uri + collectionId, conn.user, conn.password);
            col.setProperty("indent", "yes");

            // get an instance of xupdate query service
            XUpdateQueryService xupdateService = (XUpdateQueryService) col.getService("XUpdateQueryService", "1.0");
            xupdateService.setProperty("indent", "yes");

            // compile and execute xupdate expressions
            xupdateService.updateResource(documentId, String.format(UPDATE, quantityPath, newQuantity));
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
        return null;
    }

    @PUT
    @Path("/{id}/decrement")
    @Consumes("application/xml")
    public Vaccine decrementQuantityByOne(@PathParam("id") String id)
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
        return null;
    }

    @DELETE
    @Path("/{id}")
    public Vaccine deleteNewVaccine(@PathParam("id") int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        String collectionId = "/db/sample/clerk/" + VACCINES_COLLECTION_NAME;
        String documentId = id + ".xml";

        Class<?> cl = Class.forName(conn.driver);
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        Collection col = null;

        try {
            // get the collection
            col = DatabaseManager.getCollection(conn.uri + collectionId, conn.user, conn.password);
            col.setProperty("indent", "yes");
            col.removeResource(col.getResource(documentId));
            System.out.println("[INFO] Removed document from the collection");

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
        return null;
    }



}
