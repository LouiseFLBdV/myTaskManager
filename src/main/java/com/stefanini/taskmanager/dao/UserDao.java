package com.stefanini.taskmanager.dao;

import com.stefanini.taskmanager.HibernateUtil;
import com.stefanini.taskmanager.entities.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class UserDao implements Dao<User> {
    private Session session;


    public UserDao(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public List<User> getAll() {
        checkSession();
        return session.createQuery("from User").list();
    }

    @Override
    public User get(long id) {
        checkSession();
        return session.get(User.class, id);
    }

    @Override
    public User create(User entity) {
        checkSession();
        session.save(entity);
        return entity;
    }

    @Override
    public void update(User entity) {
        checkSession();
        session.merge(entity);
    }

    @Override
    public void delete(User entity) {
        session.delete(entity);
        checkSession();
    }

    public User userNameGet(String userName){
        checkSession();
        Object userGet = session.createQuery("from User where userName = userName").getResultList().get(0);
        return (User) userGet;
    }

    public void checkSession() {
        if (!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }
    }

    public void commit(){
        session.getTransaction().commit();
    }
}
