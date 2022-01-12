package com.vakcinisoni.models.Chain;

import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.models.constants.Constants;
import com.vakcinisoni.util.ObjectParser;
import org.xmldb.api.modules.XMLResource;

public class ImmunizationAccordanceParser extends ParserChain {

    @Override
    public Object parse(XMLResource resource) {
        setNext(new ImmunizationReportParser());
        try {
            return (ImmunizationAccordance) ObjectParser.parseToObject(resource, Constants.PATH_TO_MODELS);
        }
        catch (Exception e){
            return next.parse(resource);
        }
    }
}
