package com.vakcinisoni.repository.impl;

import com.vakcinisoni.models.Term;
import com.vakcinisoni.models.VaccineCandidate;
import com.vakcinisoni.services.DbService;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TermRepository extends CrudRepository<Term>{

    private static final String TERMS_COLLECTION_NAME = "terms";

    public TermRepository() throws IOException{
        super(TERMS_COLLECTION_NAME);
    }

    @Override
    public Term save(Term term) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        databaseUtils.createDatabaseConnection();

        org.xmldb.api.base.Collection col = null;

        try {
            Long id = term.getStart();

            DbService.writeToDb(term, collectionId, id + "");
        } finally {
            // don't forget to cleanup
            if(col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }

        return term;
    }

    public Term findFirstFree(VaccineCandidate candidate) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
        Collection<Term> terms = super.findAll("/term");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(candidate.getDate());
        long parsedDate = date.getTime();
        List<Term> futureFreeTerms = terms
                .stream()
                .filter(term -> !term.isTaken()
                                && term.getStart() > parsedDate
                                && term.getLocation().equals(candidate.getLocation()))
                .collect(Collectors.toList());
        if(futureFreeTerms.get(0) != null)
            return futureFreeTerms.get(0);
        else{
            Term lastTerm = new Term();
            for(Term t : terms){
                if(t.getStart() > lastTerm.getStart()){
                    lastTerm = t;
                }
            }
            Term newTerm = new Term(lastTerm.getStart()+30*60*60*1000, lastTerm.getFinish()+30*60*60*1000, true, candidate.getLocation());
            save(newTerm);
            return newTerm;
        }
    }
}
