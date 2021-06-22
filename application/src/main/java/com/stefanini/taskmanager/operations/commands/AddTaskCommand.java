package com.stefanini.taskmanager.operations.commands;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;

import java.util.ArrayList;
import java.util.List;

public class AddTaskCommand extends AbstractCommand {

    public AddTaskCommand(String[] args) {
        setArgs(args);
        setCommandName("addtask");
    }

    @Override
    public void execute() {
        List<User> users = new ArrayList<>();
        User newUser = getUserService().getByUserName(getArgs()[0]);
        users.add(newUser);

        getTaskService().create(new Task(users, getArgs()[1], getArgs()[2]));
    }
}
