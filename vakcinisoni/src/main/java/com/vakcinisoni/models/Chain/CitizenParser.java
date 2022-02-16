package com.vakcinisoni.models.Chain;

import com.vakcinisoni.models.Citizen;
import com.vakcinisoni.models.DigitalCertificate;
import com.vakcinisoni.models.constants.Constants;
import com.vakcinisoni.util.ObjectParser;
import org.xmldb.api.modules.XMLResource;

public class CitizenParser extends ParserChain{


    @Override
    public Object parse(XMLResource resource) {
        try{
            return (Citizen) ObjectParser.parseToObject(resource, Constants.PATH_TO_MODELS);
        }
        catch (Exception e){
            return null;
        }
    }
}
