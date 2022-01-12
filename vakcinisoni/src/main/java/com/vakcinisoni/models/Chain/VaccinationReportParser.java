package com.vakcinisoni.models.Chain;

import com.vakcinisoni.models.VaccinationReport;
import com.vakcinisoni.models.VaccineCandidate;
import com.vakcinisoni.models.constants.Constants;
import com.vakcinisoni.util.ObjectParser;
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
