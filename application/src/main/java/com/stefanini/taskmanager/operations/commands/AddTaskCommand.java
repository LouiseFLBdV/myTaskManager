package com.stefanini.taskmanager.operations.commands;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.operations.ApplicationLogic;

import java.util.ArrayList;
import java.util.List;

public class AddTaskCommand extends AbstractCommand {

    public AddTaskCommand(String[] args) {
        setArgs(args);
        setCommandName("addtask");
    }

    @Override
    public void run() {
        List<User> users = new ArrayList<>();
        User newUser = getUserService().getByUserName(getArgs()[0]);
        users.add(newUser);

        getTaskService().create(new Task(users, getArgs()[1], getArgs()[2]));


        ApplicationLogic.setTempOperations(ApplicationLogic.getTempOperations() - 1);
        if (ApplicationLogic.getTempOperations() == 0){
            notify();
        }
    }
}
