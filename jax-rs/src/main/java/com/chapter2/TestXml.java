package com.chapter2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Test resource (exposed at "api/testXml" path)
 */
@Path("testXml")
public class TestXml {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public TestData getXml() {
        final TestData test = new TestData();
        test.setName("Mega Name");
        test.setSize("Huge");

        return test;
    }

}