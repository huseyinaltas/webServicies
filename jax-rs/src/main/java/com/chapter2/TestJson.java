package com.chapter2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Test resource (exposed at "api/testJson" path)
 */
@Path("testJson")
public class TestJson {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TestData getJson() {
        final TestData test = new TestData();
        test.setName("Mega Name");
        test.setSize("Huge");

        return test;
    }

}
