package com.vakcinisoni.models.Chain;

import com.vakcinisoni.models.ImmunizationReport;
import com.vakcinisoni.models.constants.Constants;
import com.vakcinisoni.util.ObjectParser;
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
