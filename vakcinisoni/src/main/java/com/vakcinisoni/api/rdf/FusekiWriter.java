package com.vakcinisoni.api.rdf;

import com.vakcinisoni.util.AuthenticationUtilities;
import com.vakcinisoni.util.SparqlUtil;
import org.apache.jena.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FusekiWriter {
    private String GraphUri;
    private String rdfFilePath;

    public FusekiWriter(String filename){
        this.GraphUri = "/example/"+filename+"/metadata";
        this.rdfFilePath = "gen/"+filename+"_metadata.rdf";
    }

    public void run(AuthenticationUtilities.ConnectionProperties conn) throws IOException {

        System.out.println("[INFO] Loading triples from an RDF/XML to a model...");

        // RDF triples which are to be loaded into the model

        // Creates a default model
        Model model = ModelFactory.createDefaultModel();
        model.read(rdfFilePath);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, SparqlUtil.NTRIPLES);

        System.out.println("[INFO] Rendering model as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_XML);

        // Delete all of the triples in all of the named graphs
        UpdateRequest request = UpdateFactory.create();
        request.add(SparqlUtil.dropAll());

        /*
         * Create UpdateProcessor, an instance of execution of an UpdateRequest.
         * UpdateProcessor sends update request to a remote SPARQL update service.
         */
        UpdateProcessor processor = UpdateExecutionFactory.createRemote(request, conn.updateEndpoint);
        processor.execute();

        // Creating the first named graph and updating it with RDF data
        System.out.println("[INFO] Writing the triples to a named graph \"" + this.GraphUri + "\".");
        String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + GraphUri, new String(out.toByteArray()));
        System.out.println(sparqlUpdate);

        // UpdateRequest represents a unit of execution
        UpdateRequest update = UpdateFactory.create(sparqlUpdate);

        processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
        processor.execute();

        System.out.println("[INFO] End.");
    }
}
