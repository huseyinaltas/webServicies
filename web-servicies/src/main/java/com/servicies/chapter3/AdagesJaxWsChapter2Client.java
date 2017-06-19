package com.servicies.chapter3;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlados on 6/19/2017.
 */
public class AdagesJaxWsChapter2Client {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        URL url = new URL("http://localhost:8888/");
        URLConnection connection = url.openConnection();
        connection.setDoInput(true);
        String response = null;

        try (BufferedReader in =
                     new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            String chunk = null;
            while ((chunk = in.readLine()) != null) {
                response += chunk;
            }
        }

        // The string "null" is returned before the XML document.
        String noNullResponse = response.replaceFirst("null", "");

        System.out.println("XML resp: " + noNullResponse);
        System.out.println("parsed Ids: " + getIds(noNullResponse));
    }

    private static List<String> getIds(String xml) throws ParserConfigurationException, IOException, SAXException {
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.replaceAll(">", ">\n").getBytes());
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        fact.setNamespaceAware(true);
        DocumentBuilder builder = fact.newDocumentBuilder();
        Document doc = builder.parse(bais);
        NodeList results = doc.getElementsByTagName("int");
        List ids = new ArrayList();
        for (int i = 0; i < results.getLength(); i++) {
            ids.add(results.item(i).getChildNodes().item(0).getNodeValue());
        }

        return ids;
    }
}
