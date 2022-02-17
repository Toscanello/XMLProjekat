package com.vakcinisoni.repository.impl;

import com.vakcinisoni.models.DigitalCertificateRequest;
import com.vakcinisoni.models.DigitalCertificateRequests;
import com.vakcinisoni.models.VaccinationReport;
import com.vakcinisoni.services.DbService;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class DigitalCertificateRequestRepository extends CrudRepository<DigitalCertificateRequest>{

    private static final String DIGITAL_CERTIFICATE_REQUEST_COLLECTION_NAME = "certificate-requests";

    public DigitalCertificateRequestRepository() throws IOException {
        super(DIGITAL_CERTIFICATE_REQUEST_COLLECTION_NAME);
    }

    public List<DigitalCertificateRequest> findByJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<DigitalCertificateRequest> allRequests = (ArrayList<DigitalCertificateRequest>) this.findAll("/certificateRequest");
        List<DigitalCertificateRequest> newList = allRequests.stream().filter(acc->acc.getJmbg().equals(jmbg)).collect(Collectors.toList());
        System.out.println("NASAO JE -> " + newList.size() + "  ZA JMBG: " + jmbg );
        return newList;
    }

    @Override
    public DigitalCertificateRequest save(DigitalCertificateRequest request) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        databaseUtils.createDatabaseConnection();

        org.xmldb.api.base.Collection col = null;

        try {
            DbService.writeToDb(request, collectionId, request.getJmbg() + "-" + calculateId(request.getJmbg()));
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

        return request;

    }

    private int calculateId(String jmbg) {
        try{
            List<DigitalCertificateRequest> all = (ArrayList<DigitalCertificateRequest>)this.findAll("/certificateRequest");
            List<DigitalCertificateRequest> forUser = all
                    .stream().filter(cr -> cr.getJmbg().equals(jmbg)).collect(Collectors.toList());
            return forUser.size() + 1;
        }
        catch(Exception e){
            return 1;
        }
    }

    public List<DigitalCertificateRequest> findForJmbg(String jmbg) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<DigitalCertificateRequest> all = (ArrayList<DigitalCertificateRequest>)this.findAll("/certificateRequest");
        List<DigitalCertificateRequest> retVal = all.stream()
                    .filter(dcr -> dcr.getJmbg().equals(jmbg))
                    .collect(Collectors.toList());
        return retVal;
    }
}
