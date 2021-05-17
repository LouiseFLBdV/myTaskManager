package com.stefanini.taskmanager.dao;

import com.stefanini.taskmanager.operations.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public abstract class AbstractDao<T> implements Dao<T>{

    private Session session;
    public abstract Class<T> getEntityClass();

    public AbstractDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public List<T> getAll() {
        checkSession();
        return session.createQuery( "from " + getEntityClass().getSimpleName()).list();
    }

    @Override
    public T get(long id) {
        checkSession();
        return session.get(getEntityClass(), id);
    }

    @Override
    public T create(T entity) {
        checkSession();
        session.save(entity);
        return entity;
    }

    @Override
    public void update(T entity) {
        checkSession();
        session.merge(entity);
    }

    @Override
    public void delete(T entity) {
        session.delete(entity);
        checkSession();
    }

    @Override
    public void rollback(){
        session.getTransaction().rollback();
    }

    @Override
    public void commit() {
        session.getTransaction().commit();
    }

    public Session getSession() {
        return session;
    }

    public void checkSession() {
        if (!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }
    }
}
