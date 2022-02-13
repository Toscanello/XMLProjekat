package vakcinisoniclerk.services.contracts;

import org.xmldb.api.base.XMLDBException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

public interface IImunizationReportService {

    @GET
    @Path("/generate")
    String generateReport(@QueryParam("dateFrom") Long dateFrom, @QueryParam("dateUntil") Long dateUntil) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
