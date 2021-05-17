package com.stefanini.taskmanager.service.impl;

import com.stefanini.taskmanager.dao.Dao;
import com.stefanini.taskmanager.dao.impl.UserDaoImpl;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.service.AbstractService;
import com.stefanini.taskmanager.service.UserService;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Override
    public User userNameGet(String userName) {
        return UserDaoImpl.getUserDaoImpl().userNameGet(userName);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
