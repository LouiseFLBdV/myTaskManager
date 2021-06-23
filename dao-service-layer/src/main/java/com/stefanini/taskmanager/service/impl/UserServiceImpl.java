package com.stefanini.taskmanager.service.impl;

import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.dao.factory.DaoFactory;
import com.stefanini.taskmanager.dao.impl.UserDaoImpl;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.service.EmailService;
import com.stefanini.taskmanager.service.UserService;

import java.util.List;

import static com.stefanini.taskmanager.entities.DaoEntities.USERDAO;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private static UserServiceImpl instance;

    public static UserServiceImpl getInstance(){
        if (instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    private UserServiceImpl(){
        if (userDao==null){
            userDao = (UserDao) DaoFactory.getInstance().getDao(USERDAO);
        }
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User create(User entity) {
        userDao.create(entity);
        EmailService.sendEmail(entity);
        return entity;
    }

    @Override
    public User update(User entity) {
        userDao.update(entity);
        return entity;
    }

    @Override
    public void remove(User entity) {
        userDao.delete(entity);
    }

    //TODO set userDao, hardcode
    @Override
    public User getByUserName(String userName) {
        userDao = UserDaoImpl.getInstance();
        return userDao.getByUserName(userName);
    }

}
