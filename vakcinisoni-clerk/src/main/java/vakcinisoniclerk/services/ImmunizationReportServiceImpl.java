package vakcinisoniclerk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;
import vakcinisoniclerk.models.Vaccine;
import vakcinisoniclerk.services.contracts.IImunizationReportService;

import javax.ws.rs.Path;
import java.util.List;

@Service
@Path("/reports")
public class ImmunizationReportServiceImpl implements IImunizationReportService {


    public String generateReport(Long dateFrom, Long dateUntil) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {


        // TODO: from every ImmunizationAccordance search for row element and calculate date and count vaccines

        return "reportttt";
    }
}
