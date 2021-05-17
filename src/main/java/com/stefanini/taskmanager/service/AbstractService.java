package com.stefanini.taskmanager.service;

import com.stefanini.taskmanager.dao.Dao;
import com.stefanini.taskmanager.dao.factory.DaoFactory;
import com.stefanini.taskmanager.dao.impl.UserDaoImpl;

import java.util.List;

public abstract class AbstractService<T> implements Service<T>  {
    Dao<T> dao;
    public abstract Class<T> getEntityClass();
    public AbstractService() {
        dao = DaoFactory.getDaoFactory().getDao(getEntityClass().getSimpleName());
    }
    @Override
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    public T get(long id) {
        return dao.get(id);
    }

    @Override
    public T create(T entity) {
        dao.create(entity);
        dao.commit();
        return entity;
    }

    @Override
    public T update(T entity) {
        dao.update(entity);
        dao.commit();
        return entity;
    }

    @Override
    public void remove(T entity) {
        dao.delete(entity);
        dao.commit();
    }

    public Dao<T> getDao() {
        return dao;
    }

    public void setDao(Dao<T> dao) {
        this.dao = dao;
    }
}
