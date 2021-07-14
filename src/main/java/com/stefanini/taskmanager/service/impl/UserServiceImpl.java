package com.stefanini.taskmanager.service.impl;

import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    public UserServiceImpl(){
    }
    @Autowired
    public void setTaskDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public User create(User entity) {
        userDao.create(entity);
        return entity;
    }

    @Override
    @Transactional
    public User update(User entity) {
        userDao.update(entity);
        return entity;
    }

    @Override
    @Transactional
    public void remove(User entity) {
        userDao.delete(entity);
    }

    @Override
    @Transactional
    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }

}
