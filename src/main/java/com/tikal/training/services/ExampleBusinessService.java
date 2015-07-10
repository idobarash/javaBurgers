package com.tikal.training.services;

import com.tikal.training.dao.ExampleDao;
import com.tikal.training.model.ExampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ExampleBusinessService {

    @Autowired
    private ExampleDao exampleDao;

    @Transactional
    public ExampleEntity getById(Integer id) {
        return exampleDao.read(ExampleEntity.class, id);
    }

    @Transactional
    public void save(ExampleEntity entity) {
        exampleDao.create(entity);
    }

    @Transactional
    public void update(ExampleEntity entity) {
        exampleDao.update(entity);
    }
}
