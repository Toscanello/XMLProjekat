package vakcinisoniclerk.models.Chain;

import vakcinisoniclerk.models.DigitalCertificateRequest;
import vakcinisoniclerk.models.constants.Constants;
import vakcinisoniclerk.util.ObjectParser;
import org.xmldb.api.modules.XMLResource;

public class DigitalCertificateRequestParser extends ParserChain {

    @Override
    public Object parse(XMLResource resource) {
        setNext(new ImmunizationAccordanceParser());

        try {
            return (DigitalCertificateRequest) ObjectParser.parseToObject(resource, Constants.PATH_TO_MODELS);
        }
        catch (Exception e){
            return next.parse(resource);
        }
    }
}
