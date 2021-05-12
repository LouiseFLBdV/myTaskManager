package com.stefanini.taskmanager.dao;

import com.stefanini.taskmanager.HibernateUtil;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import org.hibernate.Session;

import java.util.List;

public class TaskDao implements Dao<Task>{
    private Session session;


    public TaskDao(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public List<Task> getAll() {
        checkSession();
        return session.createQuery("from Task").list();
    }

    @Override
    public Task get(long id) {
        checkSession();
        return session.get(Task.class, id);
    }

    @Override
    public Task create(Task entity) {
        checkSession();
        session.save(entity);
        return entity;
    }

    @Override
    public void update(Task entity) {
        checkSession();
        session.merge(entity);
    }

    @Override
    public void delete(Task entity) {
        session.delete(entity);
        checkSession();
    }

    public void checkSession() {
        if (!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }
    }

    public void closeSession(){
        session.getTransaction().commit();
        session.close();
    }
}
