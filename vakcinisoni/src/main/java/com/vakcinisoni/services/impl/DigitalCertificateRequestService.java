package com.vakcinisoni.services.impl;

import com.vakcinisoni.models.DigitalCertificateRequest;
import com.vakcinisoni.repository.impl.DigitalCertificateRequestRepository;
import com.vakcinisoni.services.IDigitalCertificateRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

@Service
public class DigitalCertificateRequestService implements IDigitalCertificateRequestService {

    @Autowired
    public DigitalCertificateRequestRepository repository;


    @Override
    public DigitalCertificateRequest save(DigitalCertificateRequest request) {
        try {
            return repository.save(request);
        } catch (XMLDBException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
