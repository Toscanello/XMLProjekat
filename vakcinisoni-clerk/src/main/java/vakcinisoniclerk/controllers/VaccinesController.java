package vakcinisoniclerk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;
import vakcinisoniclerk.models.Vaccine;
import vakcinisoniclerk.models.Vaccines;
import vakcinisoniclerk.services.VaccinesServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "vaccines")
public class VaccinesController {

    @Autowired
    private VaccinesServiceImpl vaccinesService;

    @GetMapping(value = "/", produces = "application/xml")
    public ResponseEntity<Vaccines> getAllVaccines() throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
         return new ResponseEntity<>(vaccinesService.getAllVaccines(), HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = "application/xml")
    public ResponseEntity<Vaccine> createNewVaccine(@RequestBody Vaccine vaccine) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(vaccinesService.createNewVaccine(vaccine), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/quantity")
    public ResponseEntity<Vaccine> updateVaccineQuantity(@PathVariable("id") String id, @RequestParam("quantity") int quantity) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(vaccinesService.updateVaccineQuantity(id, quantity), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/decrement")
    public ResponseEntity<String> decrementQuantityByOne(@PathVariable("id") String id) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(vaccinesService.decrementQuantityByOne(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteVaccine(@PathVariable("id") Long id) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(vaccinesService.deleteVaccine(id), HttpStatus.OK);
    }

    @GetMapping(value = "/findOne/{id}")
    public ResponseEntity<Vaccine> findOneVaccine(@PathVariable("id") String id) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return new ResponseEntity<>(vaccinesService.findOneVaccine(id), HttpStatus.OK);
    }

}
