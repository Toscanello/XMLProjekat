package com.vakcinisoni.xml2pdf.itext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * 
 * Primer demonstrira koriscenje iText PDF programskog API-a za 
 * renderovanje PDF-a na osnovu XML dokumenta. Alternativa Apache FOP-u.
 *
 */
public class HTMLTransformer {
	
	private static DocumentBuilderFactory documentFactory;
	
	private static TransformerFactory transformerFactory;
	
	public static final String INPUT_FILE = "data/VaccineReport.xml";
	
	public static final String XSL_FILE = "data/xslt-html/VaccineReport.xsl";
	
	public static final String HTML_FILE = "data/gen/itext/VaccineReport.html";
	
	static {
		/* Inicijalizacija DOM fabrike */
		documentFactory = DocumentBuilderFactory.newInstance();
		documentFactory.setNamespaceAware(true);
		documentFactory.setIgnoringComments(true);
		documentFactory.setIgnoringElementContentWhitespace(true);
		
		/* Inicijalizacija Transformer fabrike */
		transformerFactory = TransformerFactory.newInstance();
		
	}

    public org.w3c.dom.Document buildDocument(String filePath) {

    	org.w3c.dom.Document document = null;
		try {
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			document = builder.parse(new File(filePath)); 

			if (document != null)
				System.out.println("[INFO] File parsed with no errors.");
			else
				System.out.println("[WARN] Document is null.");

		} catch (Exception e) {
			return null;
			
		} 

		return document;
	}
    
    public void generateHTML(String xmlPath, String xslPath) throws FileNotFoundException {

		try {

			// Initialize Transformer instance
			StreamSource transformSource = new StreamSource(new File(xslPath));
			Transformer transformer = transformerFactory.newTransformer(transformSource);
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			// Generate XHTML
			transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

			// Transform DOM to HTML
			DOMSource source = new DOMSource(buildDocument(xmlPath));
			StreamResult result = new StreamResult(new FileOutputStream(HTML_FILE));
			transformer.transform(source, result);
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
    
    }
    
    public static void main(String[] args) throws IOException, DocumentException {

    	System.out.println("[INFO] " + HTMLTransformer.class.getSimpleName());

		HTMLTransformer pdfTransformer = new HTMLTransformer();
		
		pdfTransformer.generateHTML(INPUT_FILE, XSL_FILE);

		System.out.println("[INFO] End.");
    }
    
}