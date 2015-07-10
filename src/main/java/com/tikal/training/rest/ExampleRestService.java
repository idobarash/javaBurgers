package com.tikal.training.rest;

import com.tikal.training.model.ExampleEntity;
import com.tikal.training.services.ExampleBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Service
@Path("/example")
public class ExampleRestService {

    @Autowired
    private ExampleBusinessService exampleBusinessService;

    @GET
    @Path("/{id}")
    public ExampleEntity testGetById(@PathParam("id") Integer id) {

        return exampleBusinessService.getById(id);
    }


    @POST
    @Path("/{id}")
    public boolean testSave(ExampleEntity entity) {

        exampleBusinessService.save(entity);

        return true;
    }
}
