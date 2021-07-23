package com.stefanini.taskmanager.service;

import java.util.List;

public interface Service<T> {

    T getById(long id);
    List<T> getAll();
    T create(T entity);
    void update(T entity);
    void remove(T entity);
}
