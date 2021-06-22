package com.stefanini.taskmanager.dao.impl;

import com.stefanini.taskmanager.dao.AbstractDao;
import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.entities.User;

import java.util.List;


public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static UserDaoImpl instance;
    private UserDaoImpl() { }

    public static UserDaoImpl getInstance(){
        if (instance ==null){
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public User getByUserName(String name) {
        List<User> users = super.getByCriteria("userName",name);
        if (users.size() == 0)
            return null;
        return users.get(0);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
