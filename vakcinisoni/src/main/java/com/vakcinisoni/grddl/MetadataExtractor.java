package com.vakcinisoni.grddl;

import com.vakcinisoni.api.rdf.FusekiWriter;
import com.vakcinisoni.models.ImmunizationAccordance;
import com.vakcinisoni.util.AuthenticationUtilities;
import org.apache.xalan.processor.TransformerFactoryImpl;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXB;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Component
public class MetadataExtractor {

    private TransformerFactory transformerFactory;

    private static final String XSLT_FILE = "data/xsl/grddl.xsl";

    public MetadataExtractor() throws SAXException, IOException {

        // Setup the XSLT transformer factory
        transformerFactory = new TransformerFactoryImpl();
    }

    /**
     * Generates RDF/XML based on RDFa metadata from an XML containing
     * input stream by applying GRDDL XSL transformation.
     *
     * @param in XML containing input stream
     * @param out RDF/XML output stream
     */
    public void extractMetadata(InputStream in, OutputStream out) throws FileNotFoundException, TransformerException {

        // Create transformation source
        StreamSource transformSource = new StreamSource(new File(XSLT_FILE));

        // Initialize GRDDL transformer object
        Transformer grddlTransformer = transformerFactory.newTransformer(transformSource);

        // Set the indentation properties
        grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Initialize transformation subject
        StreamSource source = new StreamSource(in);

        // Initialize result stream
        StreamResult result = new StreamResult(out);

        // Trigger the transformation
        grddlTransformer.transform(source, result);

    }


    public void test(String xml) throws Exception {

        System.out.println("[INFO] " + MetadataExtractor.class.getSimpleName());

        String filePath = "gen/grddl_metadata.rdf";

        InputStream in = new ByteArrayInputStream(xml.getBytes());

        OutputStream out = new FileOutputStream("gen/grddl_metadata.rdf");

        extractMetadata(in, out);

        System.out.println("[INFO] File \"" + filePath + "\" generated successfully.");

        System.out.println("[INFO] End.");
    }

}
