package vakcinisoniclerk.models.Chain;

import vakcinisoniclerk.models.DigitalCertificate;
import vakcinisoniclerk.models.constants.Constants;
import vakcinisoniclerk.util.ObjectParser;
import org.xmldb.api.modules.XMLResource;

public class DigitalCertificateParser extends ParserChain {

    @Override
    public Object parse(XMLResource resource) {
        setNext(new DigitalCertificateRequestParser());
        try{
            return (DigitalCertificate) ObjectParser.parseToObject(resource, Constants.PATH_TO_MODELS);
        }
        catch (Exception e){
            return next.parse(resource);
        }
    }
}
