package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommand extends AbstractCommand {
    @Autowired
    UserService userService;
    @Override
    public void execute() {
        if(userService.getByUserName(getInputModel().getUserName())==null){
            userService.create(new User(getInputModel().getFirstName(), getInputModel().getLastName(), getInputModel().getUserName()));
        }
    }

    @Override
    public void setInputModel(InputModel inputModel) {
        super.setInputModel(inputModel);
    }
}
