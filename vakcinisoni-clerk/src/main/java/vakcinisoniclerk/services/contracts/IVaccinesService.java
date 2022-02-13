package vakcinisoniclerk.services.contracts;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.xmldb.api.base.XMLDBException;
import vakcinisoniclerk.models.Vaccine;
import vakcinisoniclerk.models.Vaccines;

import javax.ws.rs.*;
import java.util.List;

public interface IVaccinesService {

    List<Vaccine> getAllVaccines() throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    Vaccine createNewVaccine(Vaccine vaccine) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    Vaccine updateVaccineQuantity(@PathParam("id") String id, @QueryParam("quantity") int quantity) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    String decrementQuantityByOne(@PathParam("id") String id) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    Vaccine deleteNewVaccine(@PathParam("id") int id) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
