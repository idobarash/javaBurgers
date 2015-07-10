package com.tikal.training.dao;

import com.tikal.training.dao.base.AbstractDao;
import com.tikal.training.model.ExampleEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class ExampleDaoHibernateImpl extends AbstractDao<ExampleEntity> implements ExampleDao {


    @Override
    public void create(ExampleEntity entity) {
        if (entity.getDate() == null) {
            entity.setDate(new Date());
        }

        super.create(entity);
    }
}
