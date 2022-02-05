package vakcinisoniclerk.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XUpdateQueryService;
import vakcinisoniclerk.models.Vaccine;
import vakcinisoniclerk.models.Vaccines;
import vakcinisoniclerk.models.constants.Constants;
import vakcinisoniclerk.services.contracts.IVaccinesService;
import vakcinisoniclerk.util.AuthenticationUtilities;
import vakcinisoniclerk.util.ObjectParser;

import javax.ws.rs.*;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.OutputStream;

import static vakcinisoniclerk.models.template.XUpdateTemplate.INSERT_AFTER;
import static vakcinisoniclerk.models.template.XUpdateTemplate.UPDATE;

@Service
@Path("/vaccines")
public class VaccinesServiceImpl implements IVaccinesService {

    AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

    public VaccinesServiceImpl() throws IOException {
    }

    @GET
    @Path("/")
    @Produces("application/xml")
    public Vaccines getVaccines() throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Vaccines found = (Vaccines) DbService.readFromDb("store", "vaccines");
        return found;
    }

    @POST
    @Path("/")
    @Consumes("application/xml")
    public Vaccine addVaccine(Vaccine vaccine) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // initialize collection and document identifiers
        String collectionId = "/db/clerk/store";
        String documentId = "vaccines.xml";

        // initialize database driver
        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;

        try {
            // defining xpath context
            String lastElement = "/vaccines/vaccine[last()]";

            String newElement = ObjectParser.parseToXml(vaccine, Constants.PATH_TO_MODELS, false).toString();

            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId, conn.user, conn.password);
            col.setProperty("indent", "yes");

            // get an instance of xupdate query service
            System.out.println("[INFO] Fetching XUpdate service for the collection.");
            XUpdateQueryService xupdateService = (XUpdateQueryService) col.getService("XUpdateQueryService", "1.0");
            xupdateService.setProperty("indent", "yes");

            // compile and execute xupdate expressions
            System.out.println("[INFO] Inserting fragments after " + lastElement + " node.");
            long mods = xupdateService.updateResource(documentId, String.format(INSERT_AFTER, lastElement, newElement));
            System.out.println("[INFO] " + mods + " modifications processed.");
        } catch (JAXBException e) {
            e.printStackTrace();
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

    @POST
    @Path("/all")
    @Consumes("application/xml")
    public Vaccines createVaccines(Vaccines vaccines) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DbService.writeToDb(vaccines, "store", "vaccines");
        return vaccines;
    }

    @PUT
    @Path("/")
    @Consumes("application/xml")
    public Vaccines updateAllVaccines(Vaccines vaccines) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DbService.writeToDb(vaccines, "store", "vaccines");
        return vaccines;
    }

    @GET
    @Path("/{id}")
    public Vaccine updateVaccineQuantity(@PathParam("id") String id, @QueryParam("quantity") int quantity) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        // initialize collection and document identifiers
        String collectionId = "/db/clerk/store";
        String documentId = "vaccines.xml";

        // initialize database driver
        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;

        try {
            // defining xpath context
            String vaccineToUpdate = "/vaccines/vaccine[id='" + id + "']/quantity";

            System.out.println("[INFO] Vaccine for update");
            System.out.println(vaccineToUpdate);

            String updateQuantity = quantity + "";

            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId, conn.user, conn.password);
            col.setProperty("indent", "yes");

            // get an instance of xupdate query service
            System.out.println("[INFO] Fetching XUpdate service for the collection.");
            XUpdateQueryService xupdateService = (XUpdateQueryService) col.getService("XUpdateQueryService", "1.0");
            xupdateService.setProperty("indent", "yes");

            // compile and execute xupdate expressions
            System.out.println("[INFO] Inserting fragments after " + vaccineToUpdate + " node.");
            long mods = xupdateService.updateResource(documentId, String.format(UPDATE, vaccineToUpdate, updateQuantity));
            System.out.println("[INFO] " + mods + " modifications processed.");
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
