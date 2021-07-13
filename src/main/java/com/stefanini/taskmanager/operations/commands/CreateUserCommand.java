package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.model.InputModel;

public class CreateUserCommand extends AbstractCommand {

    public CreateUserCommand(InputModel inputModel){
        setInputModel(inputModel);
    }

    @Override
    public void run() {
        System.out.println(getInputModel());
        if(getUserService().getByUserName(getInputModel().getUserName().get(0))==null){
            getUserService().create(new User(getInputModel().getFirstName(), getInputModel().getLastName(), getInputModel().getUserName().get(0)));
        }else{
            getLogger().warn("User " + getInputModel().getUserName().get(0) + " already exist");
        }
    }
}
