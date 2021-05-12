package com.stefanini.taskmanager.validator;

import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.entities.User;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserNameValidator implements Validator{
    private String userName;

    public UserNameValidator(String userName) {
        this.userName = userName;
    }

    @Override
    public Boolean isValidate() {
        Boolean validate = true;
        UserDao userDao = new UserDao();
        List<User> users = userDao.getAll();
        for (User user:users) {
            if (user.getUserName().equals(userName)){
                validate = false;
                break;
            }
        }
        return validate;
    }
}
