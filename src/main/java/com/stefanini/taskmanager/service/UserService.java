package com.stefanini.taskmanager.service;

import com.stefanini.taskmanager.dto.UserDTO;

public interface UserService extends Service<UserDTO>{
    public UserDTO getByUserName(String userName);
}
