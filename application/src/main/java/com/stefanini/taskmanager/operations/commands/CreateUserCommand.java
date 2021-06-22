package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.entities.User;

public class CreateUserCommand extends AbstractCommand {

    public CreateUserCommand(String[] parameters){
        setArgs(parameters);
        setCommandName("createuser");
    }

    @Override
    public void execute() {

        if(getUserService().getByUserName(getArgs()[2])==null){
            getUserService().create(new User(getArgs()[0], getArgs()[1], getArgs()[2]));
        }else{
            getLogger().warn("User " + getArgs()[2] + " already exist");
        }
    }
}
