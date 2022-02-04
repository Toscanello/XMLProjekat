package vakcinisoniclerk.models.Chain;

import vakcinisoniclerk.models.ImmunizationReport;
import vakcinisoniclerk.models.constants.Constants;
import vakcinisoniclerk.util.ObjectParser;
import org.xmldb.api.modules.XMLResource;

public class ImmunizationReportParser extends ParserChain {

    @Override
    public Object parse(XMLResource resource) {
        setNext(new VaccinationReportParser());
        try{
            return (ImmunizationReport) ObjectParser.parseToObject(resource, Constants.PATH_TO_MODELS);
        }
        catch (Exception e){
            return next.parse(resource);
        }
    }
}
