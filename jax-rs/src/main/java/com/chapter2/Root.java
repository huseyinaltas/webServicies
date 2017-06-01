package com.chapter2;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "api/" path)
 */
@Path("/")
public class Root {

    @Context
    HttpServletResponse currentResponse;

    /**
     * Redirect to application.wadl as a convenience.
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public void get() {
        try {
            currentResponse.sendRedirect("application.wadl");
        } catch (IOException e) {
            // Ignore. This is just a convenience method anyway.
        }
    }

}