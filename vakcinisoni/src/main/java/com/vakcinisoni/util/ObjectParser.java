package com.vakcinisoni.util;

import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class ObjectParser {

    public static Object parseToObject(XMLResource resource, String pathToClass) throws JAXBException, XMLDBException {
        // e.g. pathToClass = "rs.ac.uns.ftn.examples.xmldb.bookstore"

        JAXBContext context = JAXBContext.newInstance(pathToClass);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return unmarshaller.unmarshal(resource.getContentAsDOM());
    }

    public static OutputStream parseToXml(Object object, String pathToClass) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(pathToClass);
        OutputStream os = new ByteArrayOutputStream();

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // marshal the contents to an output stream
        marshaller.marshal(object, os);

        return os;
    }
}
