package com.stefanini.taskmanager.dao.impl;


import com.stefanini.taskmanager.dao.AbstractDao;
import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public UserDaoImpl() { }

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
