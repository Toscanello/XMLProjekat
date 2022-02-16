package com.vakcinisoni.xml2pdf.xslfo;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import net.sf.saxon.TransformerFactoryImpl;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

/**
 * 
 * Primer demonstrira koriscenje Apache FOP programskog API-a za 
 * renderovanje PDF-a primenom XSL-FO transformacije na XML dokumentu.
 *
 */
public class XSLFOTransformer {
	
	private FopFactory fopFactory;
	
	private TransformerFactory transformerFactory;
	
	public String INPUT_FILE;//= "data/DigitalCert.xml"
	
	public String XSL_FILE ;//= "data/xsl/DigitalCert.xsl"
	
	public String OUTPUT_FILE; // = "data/gen/DigitalCert.pdf";
	
	
	public XSLFOTransformer(String inputFile, String xslFile, String outputFile) throws SAXException, IOException {
		
		// Initialize FOP factory object
		fopFactory = FopFactory.newInstance(new File("src/main/java/com/vakcinisoni/xml2pdf/fop.xconf"));
		
		// Setup the XSLT transformer factory
		transformerFactory = new TransformerFactoryImpl();
		INPUT_FILE = inputFile;
		XSL_FILE = xslFile;
		OUTPUT_FILE = outputFile;
	}

	public void generatePDF() throws Exception {

		System.out.println("[INFO] " + XSLFOTransformer.class.getSimpleName());
		
		// Point to the XSL-FO file
		File xslFile = new File(XSL_FILE);

		// Create transformation source
		StreamSource transformSource = new StreamSource(xslFile);
		
		// Initialize the transformation subject
		StreamSource source = new StreamSource(new File(INPUT_FILE));

		// Initialize user agent needed for the transformation
		FOUserAgent userAgent = fopFactory.newFOUserAgent();
		
		// Create the output stream to store the results
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		// Initialize the XSL-FO transformer object
		Transformer xslFoTransformer = transformerFactory.newTransformer(transformSource);
		
		// Construct FOP instance with desired output format
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);

		// Resulting SAX events 
		Result res = new SAXResult(fop.getDefaultHandler());

		// Start XSLT transformation and FOP processing
		xslFoTransformer.transform(source, res);

		// Generate PDF file
		File pdfFile = new File(OUTPUT_FILE);
		if (!pdfFile.getParentFile().exists()) {
			System.out.println("[INFO] A new directory is created: " + pdfFile.getParentFile().getAbsolutePath() + ".");
			pdfFile.getParentFile().mkdir();
		}
		
		OutputStream out = new BufferedOutputStream(new FileOutputStream(pdfFile));
		out.write(outStream.toByteArray());

		System.out.println("[INFO] File \"" + pdfFile.getCanonicalPath() + "\" generated successfully.");
		out.close();
		
		System.out.println("[INFO] End.");

	}

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

	public String getOUTPUT_FILE() {
		return OUTPUT_FILE;
	}

	public void setOUTPUT_FILE(String OUTPUT_FILE) {
		this.OUTPUT_FILE = OUTPUT_FILE;
	}
}
