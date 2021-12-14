package com.shadowsoft.tambu;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class HelloWorld {
    private static final String WORLD = "World";

    @Inject
    HelloService helloService;

    @GET
    @Path("/json")
    @Produces({ "application/json" })
    public String getHelloWorldJSON() {
        return "{\"result\":\"" + helloService.createHelloMessage(WORLD) + "\"}";
    }

    @GET
    @Path("/xml")
    @Produces({ "application/xml" })
    public String getHelloWorldXML() {
        return "<xml><result>" + helloService.createHelloMessage(WORLD) + "</result></xml>";
    }

    @GET
    @Path("/text")
    @Produces({ "text/plain" })
    public String getHelloWorldTXT() {
        return helloService.createHelloMessage(WORLD);
    }
}
