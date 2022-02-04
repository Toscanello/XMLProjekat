package vakcinisoniclerk.models.Chain;

import vakcinisoniclerk.models.VaccinationReport;
import vakcinisoniclerk.models.VaccineCandidate;
import vakcinisoniclerk.models.constants.Constants;
import vakcinisoniclerk.util.ObjectParser;
import org.xmldb.api.modules.XMLResource;

public class VaccinationReportParser extends ParserChain {

    @Override
    public Object parse(XMLResource resource) {
        setNext(new VaccineCandidateParser());
        try{
            return (VaccinationReport) ObjectParser.parseToObject(resource, Constants.PATH_TO_MODELS);
        }
        catch (Exception e){
            return next.parse(resource);
        }
    }
}
