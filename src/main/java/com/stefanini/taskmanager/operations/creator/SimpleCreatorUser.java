package com.stefanini.taskmanager.operations.creator;

import com.stefanini.taskmanager.dao.impl.UserDaoImpl;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.operations.validator.UserNameValidator;
import com.stefanini.taskmanager.operations.validator.Validator;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.impl.UserServiceImpl;

public class SimpleCreatorUser implements CreatorUser {
    private final String[] parameters;
    private String firstName;
    private String lastName;
    private String userName;
    private Validator validator;

    public SimpleCreatorUser(String[] parameters){
        this.parameters = parameters;
    }

    @Override
    public void createUser() {
        this.firstName = parameters[1].substring(4);
        this.lastName = parameters[2].substring(4);
        this.userName = parameters[3].substring(4);
        validator = new UserNameValidator(userName);
        if(validator.isValidate()){
            UserService userService = new UserServiceImpl();
            userService.create(new User(firstName, lastName, userName));
        }
    }
}
