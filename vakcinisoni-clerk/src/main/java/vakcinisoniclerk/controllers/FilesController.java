package vakcinisoniclerk.controllers;

import vakcinisoniclerk.models.Chain.DigitalCertificateParser;
import vakcinisoniclerk.models.Chain.ParserChain;
import vakcinisoniclerk.util.AuthenticationUtilities;
import vakcinisoniclerk.util.AuthenticationUtilities.ConnectionProperties;

import org.exist.xmldb.EXistResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;

import javax.xml.transform.OutputKeys;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "files")
public class FilesController {

    ConnectionProperties conn = AuthenticationUtilities.loadProperties();

    public FilesController() throws IOException {
    }

    @GetMapping("/read/{name}")
    public ResponseEntity<Object> readFile(@PathVariable("name") String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {

        // initialize collection and document identifiers
        String collectionId = null;
        String documentId = null;

        System.out.println("[INFO] Using defaults.");

        collectionId = "/db/sample/library";
        documentId = name + ".xml";

        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- document ID: " + documentId + "\n");

        // initialize database driver
        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;
        XMLResource res = null;

        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            col.setProperty(OutputKeys.INDENT, "yes");

            System.out.println("[INFO] Retrieving the document: " + documentId);
            res = (XMLResource)col.getResource(documentId);

            if(res == null) {
                System.out.println("[WARNING] Document '" + documentId + "' can not be found!");
            } else {

                System.out.println("[INFO] Showing the document as XML resource: ");

                ParserChain chain = new DigitalCertificateParser();
                Object obj = chain.parse(res);

                System.out.println("\n\nREADING OBJECT\n");
                System.out.println(obj);
                return new ResponseEntity<>(obj, HttpStatus.OK);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //don't forget to clean up!

            if(res != null) {
                try {
                    ((EXistResource)res).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }

            if(col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }

        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/write/{fileName}")
    public ResponseEntity<String> writeFile(@PathVariable("fileName") String fileName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {


        // initialize collection and document identifiers
        String collectionId = null;
        String documentId = null;
        String filePath = null;

        System.out.println("[INFO] Using defaults.");

        collectionId = "/db/sample/library";
        documentId = fileName + ".xml";

        filePath = "data/" + fileName + ".xml";

        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- document ID: " + documentId);
        System.out.println("\t- file path: " + filePath + "\n");

        // initialize database driver
        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);


        // encapsulation of the database driver functionality
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        // entry point for the API which enables you to get the Collection reference
        DatabaseManager.registerDatabase(database);

        // a collection of Resources stored within an XML database
        Collection col = null;
        XMLResource res = null;

        try {

            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = getOrCreateCollection(collectionId);

            /*
             *  create new XMLResource with a given id
             *  an id is assigned to the new resource if left empty (null)
             */
            System.out.println("[INFO] Inserting the document: " + documentId);
            res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);

            File f = new File(filePath);

            if(!f.canRead()) {
                System.out.println("[ERROR] Cannot read the file: " + filePath);
                return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
            }

            res.setContent(f);
            System.out.println("[INFO] Storing the document: " + res.getId());

            col.storeResource(res);
            System.out.println("[INFO] Done.");

        } finally {

            //don't forget to cleanup
            if(res != null) {
                try {
                    ((EXistResource)res).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }

            if(col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }

        return new ResponseEntity<>("UROS SMEKEEEEER", HttpStatus.OK);
    }

    private Collection getOrCreateCollection(String collectionUri) throws XMLDBException {
        return this.getOrCreateCollection(collectionUri, 0);
    }

    private Collection getOrCreateCollection(String collectionUri, int pathSegmentOffset) throws XMLDBException {

        Collection col = DatabaseManager.getCollection(this.conn.uri + collectionUri, this.conn.user, this.conn.password);

        // create the collection if it does not exist
        if(col == null) {

            if(collectionUri.startsWith("/")) {
                collectionUri = collectionUri.substring(1);
            }

            String pathSegments[] = collectionUri.split("/");

            if(pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();

                for(int i = 0; i <= pathSegmentOffset; i++) {
                    path.append("/" + pathSegments[i]);
                }

                Collection startCol = DatabaseManager.getCollection(conn.uri + path, conn.user, conn.password);

                if (startCol == null) {

                    // child collection does not exist

                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parentCol = DatabaseManager.getCollection(conn.uri + parentPath, conn.user, conn.password);

                    CollectionManagementService mgt = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");

                    System.out.println("[INFO] Creating the collection: " + pathSegments[pathSegmentOffset]);
                    col = mgt.createCollection(pathSegments[pathSegmentOffset]);

                    col.close();
                    parentCol.close();

                } else {
                    startCol.close();
                }
            }
            return getOrCreateCollection(collectionUri, ++pathSegmentOffset);
        } else {
            return col;
        }
    }
}
