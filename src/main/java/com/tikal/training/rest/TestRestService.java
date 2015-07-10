package com.tikal.training.rest;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Service
@Path("/test")
public class TestRestService {

    @GET
    @Path("/{id}")
    public String testGetById(@PathParam("id") Integer id) {

        return "SUCCESS";

    }
}
