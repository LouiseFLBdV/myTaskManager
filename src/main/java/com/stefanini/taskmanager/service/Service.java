package com.stefanini.taskmanager.service;

import java.util.List;

public interface Service<T> {

    T getById(long id);
    List<T> getAll();
    T save(T entity);
    void delete(T entity);
}
