package com.stefanini.taskmanager.dao;

import java.util.List;

public interface Dao<T> {

    List<T> getAll();
    T get(long id);
    T create(T entity);
    void update(T entity);
    void delete(T entity);
    void commit();
    void rollback();
}