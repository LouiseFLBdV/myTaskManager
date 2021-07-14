package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.model.OutputModel;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommand extends AbstractCommand {
    @Autowired
    UserService userService;
    @Override
    public OutputModel execute() {
        User user = null;
        OutputModel outputModel = new OutputModel();
        if(userService.getByUserName(getInputModel().getUserName())==null){
            user = userService.create(new User(getInputModel().getFirstName(), getInputModel().getLastName(), getInputModel().getUserName()));
        }
        outputModel.setUser(user);
        return outputModel;
    }

    @Override
    public void setInputModel(InputModel inputModel) {
        super.setInputModel(inputModel);
    }
}
