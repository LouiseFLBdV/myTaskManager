package com.stefanini.taskmanager.service.impl;

import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.util.ConverterEntityDTO;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private ConverterEntityDTO converterEntityDTO;
    public UserServiceImpl(){ }

    @Override
    @Transactional
    public UserDTO getById(long id) {
        return converterEntityDTO.convertToUserDTO(userDao.getById(id));
    }

    @Override
    @Transactional
    public List<UserDTO> getAll() {
        List<User> users = userDao.getAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        users.forEach(user -> {
            usersDTO.add(converterEntityDTO.convertToUserDTO(user));
        });
        return usersDTO;
    }

    @Override
    @Transactional
    public UserDTO create(UserDTO user) {
        return converterEntityDTO.convertToUserDTO(userDao.create(converterEntityDTO.convertToUserEntity(user)));
    }

    @Override
    @Transactional
    public void update(UserDTO user) {
        userDao.update(converterEntityDTO.convertToUserEntity(user));
    }

    @Override
    @Transactional
    public void remove(UserDTO user) {
        userDao.delete(converterEntityDTO.convertToUserEntity(user));
    }

    @Override
    @Transactional
    public UserDTO getByUserName(String userName) {
        return converterEntityDTO.convertToUserDTO(userDao.getByUserName(userName));
    }
}
