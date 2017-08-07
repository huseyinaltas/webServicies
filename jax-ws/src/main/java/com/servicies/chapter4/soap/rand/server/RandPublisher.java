package com.servicies.chapter4.soap.rand.server;

import com.servicies.chapter4.soap.rand.handlers.ReadHeaderHandler;

import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vlados on 6/21/2017.
 */
public class RandPublisher {
    public static void main(String[ ] args) {
        final String url = "http://localhost:8888/rs";
        System.out.println("Publishing RandService at endpoint " + url);
        Endpoint endpoint = Endpoint.create(new RandService());
        Binding binding = endpoint.getBinding();
        List<Handler> handlers = new LinkedList<>();
        handlers.add(new ReadHeaderHandler());
        binding.setHandlerChain(handlers);
        endpoint.publish(url);
    }
}
