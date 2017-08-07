package com.servicies.chapter4.soap.rand.handlers;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

/**
 * Created by vlados on 8/7/2017.
 */
public class AddHeaderHandler implements SOAPHandler<SOAPMessageContext> {

    private String headerValue;

    public AddHeaderHandler(String headerValue) {
        this.headerValue = headerValue;
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outbound) {
            try {
                SOAPMessage message = context.getMessage();
                SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
                SOAPHeaderElement soapHeaderElement = envelope.getHeader().addHeaderElement(new QName("uri", "headerName"));
                soapHeaderElement.addTextNode(headerValue);
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}
