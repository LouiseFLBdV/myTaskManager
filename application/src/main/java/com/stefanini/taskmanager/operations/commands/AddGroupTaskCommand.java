package com.stefanini.taskmanager.operations.commands;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.operations.ApplicationLogic;

import java.util.ArrayList;
import java.util.List;

public class AddGroupTaskCommand extends AbstractCommand {

    public AddGroupTaskCommand(String[] parameters) {
        setArgs(parameters);
        setCommandName("addgrouptask");
    }

    @Override
    public void run() {

        List<User> users = new ArrayList<>();
        for (int i = 3; i < getArgs().length; i++){
            User newUser = getUserService().getByUserName(getArgs()[i].substring(4));
            if (newUser!= null){
                if(users.contains(newUser)){
                    getLogger().warn(newUser + " is already exist");
                }else{
                    users.add(newUser);
                }
            }
        }

        getTaskService().create(new Task(users, getArgs()[0], getArgs()[1]));
        ApplicationLogic.setTempOperations(ApplicationLogic.getTempOperations() - 1);
        if (ApplicationLogic.getTempOperations() == 0){
            notify();
        }
    }
}
