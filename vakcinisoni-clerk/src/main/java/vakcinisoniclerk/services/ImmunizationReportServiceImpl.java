package vakcinisoniclerk.services;

import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;
import vakcinisoniclerk.services.contracts.IImunizationReportService;

@Service
public class ImmunizationReportServiceImpl implements IImunizationReportService {

    public String generateReport(Long dateFrom, Long dateUntil) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        // TODO: from every ImmunizationAccordance search for row element and calculate date and count vaccines

        return "reportttt";
    }
}
