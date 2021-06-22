package com.stefanini.taskmanager.service;

import java.util.List;

public interface Service<T> {

    List<T> getAll();
    T get(long id);
    T create(T entity);
    T update(T entity);
    void remove(T entity);
}
