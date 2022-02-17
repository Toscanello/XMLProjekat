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
	
	public String INPUT_FILE;// = "data/VaccineReport.xml";
	
	public String XSL_FILE;// = "data/xslt-html/VaccineReport.xsl";
	
	public String HTML_FILE;// = "data/gen/itext/VaccineReport.html";

	public HTMLTransformer(){
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
    
    public String generateHTML() throws FileNotFoundException {

		try {

			// Initialize Transformer instance
			StreamSource transformSource = new StreamSource(new File(XSL_FILE));
			Transformer transformer = transformerFactory.newTransformer(transformSource);
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			// Generate XHTML
			transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

			// Transform DOM to HTML
			DOMSource source = new DOMSource(buildDocument(INPUT_FILE));
			StreamResult result = new StreamResult(new FileOutputStream(HTML_FILE));
			transformer.transform(source, result);

			return "success";
			
		} catch (TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}
		return "";
	}

//	public String generateXHTML() throws IOException, DocumentException{
//		//HTMLTransformer pdfTransformer = new HTMLTransformer();
//
//		return generateHTML(INPUT_FILE, XSL_FILE);
//
////		return HTML_FILE;
//	}

	public String getINPUT_FILE() {
		return INPUT_FILE;
	}

	public void setINPUT_FILE(String INPUT_FILE) {
		this.INPUT_FILE = INPUT_FILE;
	}

	public String getXSL_FILE() {
		return XSL_FILE;
	}

	public void setXSL_FILE(String XSL_FILE) {
		this.XSL_FILE = XSL_FILE;
	}

	public String getHTML_FILE() {
		return HTML_FILE;
	}

	public void setHTML_FILE(String HTML_FILE) {
		this.HTML_FILE = HTML_FILE;
	}

	//	public static void main(String[] args) throws IOException, DocumentException {
//
//    	System.out.println("[INFO] " + HTMLTransformer.class.getSimpleName());
//
//
//
//		System.out.println("[INFO] End.");
//    }
    
}
