package vakcinisoniclerk.services;

import org.xmldb.api.base.XMLDBException;
import vakcinisoniclerk.models.ImmunizationReport;
import vakcinisoniclerk.models.Reports;

import java.text.ParseException;

public interface IImunizationReportService {

    ImmunizationReport generateReport(String dateFrom, String dateUntil) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException;

    ImmunizationReport save(ImmunizationReport report);

    Reports findAll();
}
