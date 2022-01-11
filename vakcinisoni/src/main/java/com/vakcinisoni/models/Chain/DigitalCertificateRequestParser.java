package com.vakcinisoni.models.Chain;

import com.vakcinisoni.models.DigitalCertificateRequest;
import com.vakcinisoni.util.ObjectParser;
import org.xmldb.api.modules.XMLResource;

public class DigitalCertificateRequestParser extends ParserChain{

    @Override
    public Object parse(XMLResource resource) {
        try{
            return (DigitalCertificateRequest) ObjectParser.parseToObject(resource, "com.vakcinisoni.models");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
