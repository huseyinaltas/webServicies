package com.chapter2;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Let the servlet container know where to find our REST goodness.
 *
 * It'll be deployed at /api, the WADL is available at api/application.wadl
 */
@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        packages("org.lick.me.jaxrs.quickstart");
    }
}