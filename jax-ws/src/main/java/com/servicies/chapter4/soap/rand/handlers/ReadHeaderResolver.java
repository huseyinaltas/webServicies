package com.servicies.chapter4.soap.rand.handlers;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlados on 8/8/2017.
 */
public class ReadHeaderResolver implements HandlerResolver {
    @Override
    public List<Handler> getHandlerChain(PortInfo portInfo) {
        ArrayList<Handler> handlers = new ArrayList<>();
        QName serviceName = portInfo.getServiceName();
        if ("RandServiceService".equalsIgnoreCase(serviceName.getLocalPart())) {
            handlers.add(new ReadHeaderHandler());
        }

        return handlers;
    }
}
