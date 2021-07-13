package com.stefanini.taskmanager.operations.commands;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.model.InputModel;

import java.util.ArrayList;
import java.util.List;

public class AddTaskCommand extends AbstractCommand {

    public AddTaskCommand(InputModel inputModel) {
        setInputModel(inputModel);
    }

    @Override
    public void run() {
        List<User> users = new ArrayList<>();
        User newUser = getUserService().getByUserName(getInputModel().getUserName().get(0));
        users.add(newUser);

        getTaskService().create(new Task(users, getInputModel().getTaskTittle(), getInputModel().getDesc()));
    }
}
