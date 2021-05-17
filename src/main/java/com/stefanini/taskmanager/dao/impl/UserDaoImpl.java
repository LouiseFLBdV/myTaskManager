package com.stefanini.taskmanager.dao.impl;

import com.stefanini.taskmanager.dao.AbstractDao;
import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.entities.User;
import org.hibernate.Session;

import java.util.List;


public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static UserDaoImpl userDaoImpl;
    public UserDaoImpl() {
        super();
    }

    public static synchronized UserDaoImpl getUserDaoImpl(){
        if (userDaoImpl==null){
            userDaoImpl = new UserDaoImpl();
        }
        return userDaoImpl;
    }

    @Override
    public User userNameGet(String userName){
        checkSession();
        Object userGet = getSession().createQuery("from User where userName = userName").getResultList().get(0);
        return (User) userGet;
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
