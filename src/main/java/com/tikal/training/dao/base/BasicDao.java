package com.tikal.training.dao.base;

public interface BasicDao<T> {

    void create(T entity);

    T read(Class<T> type, Integer id);

    void update(T entity);

    void delete(T entity);

}
