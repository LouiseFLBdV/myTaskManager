package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.operations.ApplicationLogic;

public class CreateUserCommand extends AbstractCommand {

    public CreateUserCommand(String[] parameters){
        setArgs(parameters);
        setCommandName("createuser");
    }

    @Override
    public void run() {
        if(getUserService().getByUserName(getArgs()[2])==null){
            getUserService().create(new User(getArgs()[0], getArgs()[1], getArgs()[2]));
        }else{
            getLogger().warn("User " + getArgs()[2] + " already exist");
        }
        ApplicationLogic.setTempCreateUser(ApplicationLogic.getTempCreateUser() - 1);
        ApplicationLogic.setTempOperations(ApplicationLogic.getTempOperations() - 1);
        if (ApplicationLogic.getTempCreateUser() == 0){
            notify();
        }
    }
}
