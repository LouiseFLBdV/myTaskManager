package com.stefanini.taskmanager.dao;

import com.stefanini.taskmanager.entities.User;

public interface UserDao extends Dao<User> {
    /**
     * This method is used to select a User by user_name
     * @param userName of type String
     * @return entity of type User
     */
    public User getByUserName(String userName);
}
