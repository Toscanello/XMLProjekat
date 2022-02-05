package vakcinisoniclerk.models.Chain;

import org.xmldb.api.modules.XMLResource;
import vakcinisoniclerk.models.Vaccines;
import vakcinisoniclerk.models.constants.Constants;
import vakcinisoniclerk.util.ObjectParser;

public class VaccinesParser extends ParserChain {

    @Override
    public Object parse(XMLResource resource) {

        try{
            return (Vaccines) ObjectParser.parseToObject(resource, Constants.PATH_TO_MODELS);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
