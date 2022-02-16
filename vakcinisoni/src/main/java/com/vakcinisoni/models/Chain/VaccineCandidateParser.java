package com.vakcinisoni.models.Chain;

import com.vakcinisoni.models.DigitalCertificate;
import com.vakcinisoni.models.VaccineCandidate;
import com.vakcinisoni.models.constants.Constants;
import com.vakcinisoni.util.ObjectParser;
import org.xmldb.api.modules.XMLResource;

public class VaccineCandidateParser extends ParserChain {

    @Override
    public Object parse(XMLResource resource) {
        setNext(new CitizenParser());
        try{
            return (VaccineCandidate) ObjectParser.parseToObject(resource, Constants.PATH_TO_MODELS);
        }
        catch (Exception e){
            return next.parse(resource);
        }
    }
}
