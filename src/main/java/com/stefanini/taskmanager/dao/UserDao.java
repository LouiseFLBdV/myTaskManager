package com.stefanini.taskmanager.dao;

import com.stefanini.taskmanager.entities.User;

public interface UserDao extends Dao<User> {
    public User userNameGet(String userName);
}
