package com.stefanini.taskmanager.service;

import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.entities.User;

public interface UserService extends Service<UserDTO>{
    public UserDTO getByUserName(String userName);
}
