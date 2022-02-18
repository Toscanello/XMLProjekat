package vakcinisoniclerk.repository.impl;

import org.exist.xmldb.EXistResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;
import org.xmldb.api.modules.XUpdateQueryService;
import vakcinisoniclerk.models.Chain.DigitalCertificateParser;
import vakcinisoniclerk.models.Chain.ParserChain;
import vakcinisoniclerk.models.Vaccine;
import vakcinisoniclerk.models.constants.Constants;
import vakcinisoniclerk.repository.DatabaseUtils;
import vakcinisoniclerk.repository.ICrudRepository;
import vakcinisoniclerk.services.DbService;
import vakcinisoniclerk.util.AuthenticationUtilities;
import vakcinisoniclerk.util.ObjectParser;

import javax.xml.bind.JAXBException;
import javax.xml.transform.OutputKeys;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static vakcinisoniclerk.models.template.XUpdateTemplate.TARGET_NAMESPACE;
import static vakcinisoniclerk.models.template.XUpdateTemplate.UPDATE;

public class CrudRepository<T extends Object> implements ICrudRepository<T> {

    AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

    private DatabaseUtils databaseUtils = new DatabaseUtils();

    protected String collectionId;

    public CrudRepository() throws IOException {
    }

    public CrudRepository(String collectionName) throws IOException {
        this.collectionId = "/db/sample/clerk/" + collectionName;
    }

    @Override
    public Collection<T> findAll(String xpathExp) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Collection<T> retList = new ArrayList<>();

        databaseUtils.createDatabaseConnection();

        org.xmldb.api.base.Collection col = null;

        try {
            col = DatabaseManager.getCollection(conn.uri + collectionId);

            // get an instance of xpath query service
            XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xpathService.setProperty("indent", "yes");
            // make the service aware of namespaces, using the default one
            xpathService.setNamespace("", TARGET_NAMESPACE);

            ResourceSet result = xpathService.query(xpathExp);
            ResourceIterator i = result.getIterator();
            Resource res = null;

            while(i.hasMoreResources()) {

                try {
                    res = i.nextResource();
                    T o = (T) ObjectParser.parseToObject((XMLResource) res, Constants.PATH_TO_MODELS);
                    retList.add(o);
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

        return retList;
    }

    @Override
    public T save(T entity) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        databaseUtils.createDatabaseConnection();

        org.xmldb.api.base.Collection col = null;

        try {
            col = DbService.getOrCreateCollection(collectionId);
            long id = col.getResourceCount() + 1;

            DbService.writeToDb(entity, collectionId, id + "");
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

    @Override
    public boolean update(String documentId, String xPathSelector, String newValue) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        documentId = documentId + ".xml";

        databaseUtils.createDatabaseConnection();

        org.xmldb.api.base.Collection col = null;

        try {
            // get the collection
            col = DatabaseManager.getCollection(conn.uri + collectionId, conn.user, conn.password);
            col.setProperty("indent", "yes");

            // get an instance of xupdate query service
            XUpdateQueryService xupdateService = (XUpdateQueryService) col.getService("XUpdateQueryService", "1.0");
            xupdateService.setProperty("indent", "yes");

            // compile and execute xupdate expressions
            xupdateService.updateResource(documentId, String.format(UPDATE, xPathSelector, newValue));
            System.out.println("[INFO] Finished updating vaccine entity");
            return true;
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
    }

    @Override
    public void delete(Long id) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String documentId = id + ".xml";

        databaseUtils.createDatabaseConnection();

        org.xmldb.api.base.Collection col = null;

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
    }

    @Override
    public T findOne(String documentId) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        databaseUtils.createDatabaseConnection();

        documentId += ".xml";

        org.xmldb.api.base.Collection col = null;
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
                T obj = (T) chain.parse(res);

                System.out.println("\n\nREADING OBJECT\n");
                System.out.println(obj);
                return obj;

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
        return null;
    }

    @Override
    public File getXml(String documentId) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        databaseUtils.createDatabaseConnection();

        documentId += ".xml";

        org.xmldb.api.base.Collection col = null;
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
                File newFile = new File("data/" + documentId);
                FileWriter writer = new FileWriter("data/" + documentId);
                writer.write(res.getContent().toString());
                writer.close();
                return newFile;
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
        return null;
    }
}
