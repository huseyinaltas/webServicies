package com.servicies.chapter4.soap;

import javax.xml.ws.Endpoint;

/**
 * Created by vlados on 6/21/2017.
 */
public class RandPublisher {
    public static void main(String[ ] args) {
        final String url = "http://localhost:8888/rs";
        System.out.println("Publishing RandService at endpoint " + url);
        Endpoint.publish(url, new RandService());
    }
}
