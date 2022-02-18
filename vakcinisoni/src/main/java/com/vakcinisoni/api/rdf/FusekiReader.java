package com.vakcinisoni.api.rdf;

import com.vakcinisoni.util.AuthenticationUtilities;
import com.vakcinisoni.util.SparqlUtil;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

public class FusekiReader {

    private static String PERSON_NAMED_GRAPH_URI = "/example/immunization-accordance/metadata/1712_2021-12-07";

    public FusekiReader(String filename,String id){
        this.PERSON_NAMED_GRAPH_URI = "/example/"+filename+"/metadata/"+id;
    }

    public static String run(AuthenticationUtilities.ConnectionProperties conn) throws IOException {

        // Querying the first named graph with a simple SPARQL query
        System.out.println("[INFO] Selecting the triples from the named graph \"" + PERSON_NAMED_GRAPH_URI + "\".");
        String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + PERSON_NAMED_GRAPH_URI, "?s ?p ?o");

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);

        // Query the SPARQL endpoint, iterate over the result set...
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;

        while (results.hasNext()) {

            // A single answer from a SELECT query
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();

            // Retrieve variable bindings
            while (variableBindings.hasNext()) {

                varName = variableBindings.next();
                varValue = querySolution.get(varName);

                System.out.println(varName + ": " + varValue);
            }
            System.out.println();
        }

        // Querying the other named graph
        System.out.println("[INFO] Selecting the triples from the named graph \"" + PERSON_NAMED_GRAPH_URI + "\".");
        sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + PERSON_NAMED_GRAPH_URI, "?s ?p ?o");

        // Create a QueryExecution that will access a SPARQL service over HTTP
        query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);


        // Query the collection, dump output response as XML
        results = query.execSelect();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ResultSetFormatter.outputAsXML(outputStream, results);

        query.close();

        System.out.println("[INFO] End.");
        return outputStream.toString();
    }
}