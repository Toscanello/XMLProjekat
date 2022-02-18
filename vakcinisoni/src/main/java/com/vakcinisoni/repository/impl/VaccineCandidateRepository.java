package com.vakcinisoni.repository.impl;

import com.vakcinisoni.models.DigitalCertificateRequest;
import com.vakcinisoni.models.VaccineCandidate;
import com.vakcinisoni.models.VaccineCandidateWithId;
import com.vakcinisoni.models.VaccineCandidates;
import com.vakcinisoni.models.constants.Constants;
import com.vakcinisoni.util.ObjectParser;
import org.exist.xmldb.EXistResource;
import org.springframework.stereotype.Component;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.vakcinisoni.models.template.XUpdateTemplate.TARGET_NAMESPACE;

@Component
public class VaccineCandidateRepository extends CrudRepository<VaccineCandidate>{

    private static final String VACCINE_CANDIDATE_COLLECTION_NAME = "vaccine-candidates";

    public VaccineCandidateRepository() throws IOException {
        super(VACCINE_CANDIDATE_COLLECTION_NAME);
    }

    public int countDistinct() throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Collection<VaccineCandidate> all = findAll("/vaccineCandidate");
        List<VaccineCandidate> distinct = new ArrayList<>();

        for(VaccineCandidate vc : all){
            if(!distinct.contains(vc)){
                distinct.add(vc);
            }
        }
        return distinct.size();
    }

    public List<VaccineCandidateWithId> findForJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<VaccineCandidateWithId> allWithId = findAllWithId();
        List<VaccineCandidateWithId> retVal = allWithId.stream()
                .filter(vc -> vc.getVaccineCandidate().getJmbg().getValue().equals(jmbg))
                .collect(Collectors.toList());
        return retVal;
    }

    private List<VaccineCandidateWithId> findAllWithId() throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<VaccineCandidateWithId> retList = new ArrayList<>();

        databaseUtils.createDatabaseConnection();

        org.xmldb.api.base.Collection col = null;

        try {
            col = DatabaseManager.getCollection(conn.uri + collectionId);

            // get an instance of xpath query service
            XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xpathService.setProperty("indent", "yes");
            // make the service aware of namespaces, using the default one
            xpathService.setNamespace("", TARGET_NAMESPACE);

//            String xpathExp = "/vaccine";
            ResourceSet result = xpathService.query("/vaccineCandidate");
            ResourceIterator i = result.getIterator();
            Resource res = null;

            while(i.hasMoreResources()) {

                try {
                    res = i.nextResource();
                    VaccineCandidate o = (VaccineCandidate) ObjectParser.parseToObject((XMLResource) res, Constants.PATH_TO_MODELS);
                    String id = ((XMLResource) res).getDocumentId();
                    VaccineCandidateWithId withId = new VaccineCandidateWithId(id.strip().split("\\.")[0], o);
                    retList.add(withId);
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

}
