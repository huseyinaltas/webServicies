package com.servicies.chapter4.soap.rand.client;

import com.servicies.chapter4.soap.rand.handlers.AddHeaderHandlerResolver;

/**
 * Created by vlados on 7/30/2017.
 */
public class RandClient {
    public static void main(String[] args) {
        RandServiceService service = new RandServiceService();
        service.setHandlerResolver(new AddHeaderHandlerResolver("test"));
        RandService port = service.getRandServicePort();

        System.out.println("------------------------");
        System.out.println(port.next1());
        System.out.println("------------------------");
        System.out.println(port.nextN(4));
        System.out.println("------------------------");

    }
}
