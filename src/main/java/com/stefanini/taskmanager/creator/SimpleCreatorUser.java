package com.stefanini.taskmanager.creator;

import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.validator.UserNameValidator;
import com.stefanini.taskmanager.validator.Validator;

public class SimpleCreatorUser implements CreatorUser {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final Validator validator;

    public SimpleCreatorUser(String[] args){
        this.firstName = args[1].substring(4);
        this.lastName = args[2].substring(4);
        this.userName = args[3].substring(4);

        validator = new UserNameValidator(userName);
    }

    @Override
    public void createUser() {

        if(validator.isValidate()){
            UserDao jpaUserDao = new UserDao();
            jpaUserDao.create(new User(firstName, lastName, userName));
        }
    }
}
