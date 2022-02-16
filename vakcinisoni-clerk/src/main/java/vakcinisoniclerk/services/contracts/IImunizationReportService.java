package vakcinisoniclerk.services.contracts;

import org.xmldb.api.base.XMLDBException;

public interface IImunizationReportService {

    String generateReport(Long dateFrom, Long dateUntil) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
