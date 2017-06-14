package com.servicies.chapter2;

import javax.xml.ws.Endpoint;

/**
 * Created by vlados on 6/14/2017.
 */
public class Publisher {
    public static void main(String[] args) {
        int port = 8888;
        String url = "http://localhost:" + port + "/";
        System.out.println("Restfully publishing on port " + port);
        Endpoint.publish(url, new AdagesProvider());
    }
}
