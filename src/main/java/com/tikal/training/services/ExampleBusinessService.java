package com.tikal.training.services;

import com.tikal.training.dao.ExampleDao;
import com.tikal.training.model.ExampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExampleBusinessService {

    @Autowired
    private ExampleDao exampleDao;


    public ExampleEntity getById(Integer id) {
        return exampleDao.read(ExampleEntity.class, id);
    }


    public void save(ExampleEntity entity) {
        exampleDao.create(entity);
    }
}
