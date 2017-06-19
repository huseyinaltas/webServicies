package com.servicies.chapter3.xsd.classes;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.File;

/**
 * Created by vlados on 6/19/2017.
 */
public class ConvertorUsingXsdScheme {
    private static final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "\n" +
            "<shiporder orderid=\"889923\"\n" +
            "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "xsi:noNamespaceSchemaLocation=\"shiporder.xsd\">\n" +
            "  <orderperson>John Smith</orderperson>\n" +
            "  <shipto>\n" +
            "    <name>Ola Nordmann</name>\n" +
            "    <address>Langgt 23</address>\n" +
            "    <city>4000 Stavanger</city>\n" +
            "    <country>Norway</country>\n" +
            "  </shipto>\n" +
            "  <item>\n" +
            "    <title>Empire Burlesque</title>\n" +
            "    <note>Special Edition</note>\n" +
            "    <quantity>1</quantity>\n" +
            "    <price>10.90</price>\n" +
            "  </item>\n" +
            "  <item>\n" +
            "    <title>Hide your heart</title>\n" +
            "    <quantity>1</quantity>\n" +
            "    <price>9.90</price>\n" +
            "  </item>\n" +
            "</shiporder>";

    public static void main(String[] args) throws JAXBException, SAXException {
        System.out.println(getOrderPerson());

    }

    private static String getOrderPerson() throws SAXException, JAXBException {
        final String fileName = "web-servicies\\src\\main\\java\\com\\servicies\\chapter3\\xsd\\classes\\shiporder.xsd";
        final String schemaUri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(schemaUri);
        Schema schema = factory.newSchema(new File(fileName));

        JAXBContext ctx = JAXBContext.newInstance(Shipordertype.class);
        Unmarshaller um = ctx.createUnmarshaller();
        um.setSchema(schema);

        Shipordertype shipOrder = (Shipordertype)
                um.unmarshal(new ByteArrayInputStream(xml.getBytes()));

        return shipOrder.getOrderperson();
    }
}
