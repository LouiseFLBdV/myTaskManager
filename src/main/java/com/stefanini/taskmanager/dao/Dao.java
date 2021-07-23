package com.stefanini.taskmanager.dao;

import java.util.List;

public interface Dao<T> {

    /**
     * This method is used to get all entity
     * @return List entities
     */
    T getById(long id);
    /**
     * This method is used to get all entity
     * @return List entities
     */
    List<T> getAll();
    /**
     * This method is used to add entity
     * @return entity
     */
    T create(T entity);
    /**
     * This method is used to update entity
     */
    void update(T entity);
    /**
     * This method is used to remove entity
     */
    void delete(T entity);
}