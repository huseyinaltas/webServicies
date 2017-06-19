package com.servicies.chapter3.conversion;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlados on 6/19/2017.
 */
class Marshal {
    private static final String fileName = "bd.mar";

    public static void main(String[] args) {
        new Marshal().runExample();
    }

    private void runExample() {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Skier.class);
            Marshaller m = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
// Marshal a Skier object: 1st to stdout, 2nd to file
            Skier skier = createSkier();
            m.marshal(skier, System.out);
            FileOutputStream out = new FileOutputStream(fileName);
            m.marshal(skier, out);
            out.close();
// Unmarshal as proof of concept
            Unmarshaller u = ctx.createUnmarshaller();
            Skier bdClone = (Skier) u.unmarshal(new File(fileName));
            System.out.println();
            m.marshal(bdClone, System.out);
        } catch (JAXBException | IOException e) {
            System.err.println(e);
        }
    }

    private Skier createSkier() {
        Person bd = new Person("Bjoern Daehlie", 49, "Male");
        List<String> list = new ArrayList<>();
        list.add("12 Olympic Medals");
        list.add("9 World Championships");
        list.add("Winningest Winter Olympian");
        list.add("Greatest Nordic Skier");
        return new Skier(bd, "Norway", list);
    }
}