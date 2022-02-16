package vakcinisoniclerk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;
import vakcinisoniclerk.models.Vaccine;
import vakcinisoniclerk.services.VaccinesServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping(value = "vaccines")
public class VaccinesController {

    @Autowired
    private VaccinesServiceImpl vaccinesService;

    @GetMapping("/")
    @Produces("application/xml")
    public ResponseEntity<List<Vaccine>> getAllVaccines() throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
         return new ResponseEntity<>(vaccinesService.getAllVaccines(), HttpStatus.OK);
    }

    @PostMapping("/")
    @Consumes("application/xml")
    public ResponseEntity<Vaccine> createNewVaccine(@RequestBody Vaccine vaccine) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(vaccinesService.createNewVaccine(vaccine), HttpStatus.OK);
    }

    @PutMapping("/{id}/quantity")
    @Consumes("application/xml")
    public ResponseEntity<Vaccine> updateVaccineQuantity(@RequestBody Vaccine vaccine) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(vaccinesService.createNewVaccine(vaccine), HttpStatus.OK);
    }
}
