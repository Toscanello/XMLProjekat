package vakcinisoniclerk.services.contracts;

import org.springframework.web.bind.annotation.PathVariable;
import org.xmldb.api.base.XMLDBException;
import vakcinisoniclerk.models.Vaccine;
import vakcinisoniclerk.models.Vaccines;

import javax.ws.rs.*;

public interface IVaccinesService {

    Vaccines getVaccines() throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    Vaccine addVaccine(Vaccine vaccine) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    Vaccines createVaccines(Vaccines vaccines) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    Vaccines updateAllVaccines(Vaccines vaccines) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    Vaccine updateVaccineQuantity(@PathVariable String id, @QueryParam("quantity") int quantity) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
