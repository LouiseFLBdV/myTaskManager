package com.stefanini.taskmanager.operations.validator;

import com.stefanini.taskmanager.dao.impl.UserDaoImpl;
import com.stefanini.taskmanager.entities.User;

import java.util.List;

public class UserNameValidator implements Validator{
    private String userName;

    public UserNameValidator(String userName) {
        this.userName = userName;
    }

    @Override
    public Boolean isValidate() {
        Boolean validate = true;
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        List<User> users = userDaoImpl.getAll();
        for (User user:users) {
            if (user.getUserName().equals(userName)){
                validate = false;
                break;
            }
        }
        return validate;
    }
}
