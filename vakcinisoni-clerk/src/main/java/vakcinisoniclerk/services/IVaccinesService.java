package vakcinisoniclerk.services;

import org.xmldb.api.base.XMLDBException;
import vakcinisoniclerk.models.Vaccine;
import vakcinisoniclerk.models.Vaccines;

public interface IVaccinesService {

    Vaccines getAllVaccines() throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    Vaccine createNewVaccine(Vaccine vaccine) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    Vaccine updateVaccineQuantity(String id, int quantity) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    String decrementQuantityByOne(String id) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    String deleteVaccine(Long id) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
