package com.stefanini.taskmanager.service;

import com.stefanini.taskmanager.entities.User;

public interface UserService extends Service<User>{
    public User userNameGet(String userName);
}
