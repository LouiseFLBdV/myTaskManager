package com.stefanini.taskmanager.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> getAll();
    T get(long id);
    T create(T entity);
    void update(T entity);
    void delete(T entity);

}