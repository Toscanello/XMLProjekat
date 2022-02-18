package vakcinisoniclerk.services;

import vakcinisoniclerk.models.AllDocumentsForCitizen;

import java.util.List;

public interface IClerkService {

    AllDocumentsForCitizen getAllDocumentsByPhrase(String phrase);
}
