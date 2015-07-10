package com.tikal.training.rest;

import com.tikal.training.model.ExampleEntity;
import com.tikal.training.services.ExampleBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;

@Service
@Path("/example")
@Produces("application/json")
public class ExampleRestService {

    @Autowired
    private ExampleBusinessService exampleBusinessService;

    @GET
    @Path("/{id}")
    public ExampleEntity testGetById(@PathParam("id") Integer id) {

        return exampleBusinessService.getById(id);
    }


    @POST
    public boolean testSave(ExampleEntity entity) {

        exampleBusinessService.save(entity);

        return true;
    }

    @PUT
    public ExampleEntity updateEntity(ExampleEntity entity) {

        exampleBusinessService.update(entity);

        return exampleBusinessService.getById(entity.getId());
    }
}
