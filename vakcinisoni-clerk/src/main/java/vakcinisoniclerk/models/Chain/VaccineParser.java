package vakcinisoniclerk.models.Chain;

import org.xmldb.api.modules.XMLResource;
import vakcinisoniclerk.models.Vaccine;
import vakcinisoniclerk.models.constants.Constants;
import vakcinisoniclerk.util.ObjectParser;

public class VaccineParser extends ParserChain {

    @Override
    public Object parse(XMLResource resource) {
        setNext(new VaccinesParser());
        try{
            return (Vaccine) ObjectParser.parseToObject(resource, Constants.PATH_TO_MODELS);
        }
        catch (Exception e){
            return next.parse(resource);
        }
    }
}
