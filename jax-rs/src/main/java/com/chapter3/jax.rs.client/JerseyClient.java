package com.chapter3.jax.rs.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

import javax.ws.rs.core.MediaType;
import java.net.URI;

/**
 * Created by vlados on 6/20/2017.
 */
public class JerseyClient {
    private static final String baseUrl = "http://localhost:8080/api/predictions";

    public static void main(String[] args) {
        new JerseyClient().demo();
    }

    private void demo() {
        Client client = Client.create();
        client.setFollowRedirects(true); // in case the service redirects
        WebResource resource = client.resource(baseUrl);
        getAllDemo(resource);
        postDemo(resource); // same resource but different verb
//        String url = baseUrl + "/json/1";
//        resource = client.resource(url);
        getOneDemo(resource);
//        url = baseUrl + "/delete/1";
//        resource = client.resource(url);
        deleteDemo(resource); // delete id = 32
    }

    private void getAllDemo(WebResource resource) {
// GET all XML
        String response =
                resource.uri(URI.create("xml")).accept(MediaType.APPLICATION_XML_TYPE).get(String.class);
        report("GET all in XML:\n", response);
        // GET all JSON
        response =
                resource.uri(URI.create("json")).accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        report("GET all in JSON:\n", response);
    }

    private void getOneDemo(WebResource resource) {
        String response =
                resource.uri(URI.create("xml/1")).accept(MediaType.APPLICATION_XML_TYPE).get(String.class);
        report("GET one in XML:\n", response);
        response =
                resource.uri(URI.create("json/1")).accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        report("GET one in JSON:\n", response);
    }

    private void postDemo(WebResource resource) {
        Form form = new Form(); // HTTP body, a simple hash
        form.add("who", "William Butler Yeats");
        form.add("what", "I know that I shall meet my fate");
        String response =
                resource.uri(URI.create("create")).type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                        .accept(MediaType.TEXT_PLAIN_TYPE)
                        .post(String.class, form);
        report("POST:\n", response);
    }

    private void deleteDemo(WebResource resource) {
        String response =
                resource.uri(URI.create("delete/1")).accept(MediaType.TEXT_PLAIN_TYPE).delete(String.class);
        report("DELETE:\n", response);
    }

    private void report(String msg, String response) {
        System.out.println("\n" + msg + response);
    }
}
