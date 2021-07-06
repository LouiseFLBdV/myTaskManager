package com.stefanini.taskmanager.operations.commands;
import com.stefanini.taskmanager.dto.InputArgs;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.operations.ApplicationLogic;

import java.util.ArrayList;
import java.util.List;

public class AddTaskCommand extends AbstractCommand {

    public AddTaskCommand(InputArgs inputArgs) {
        setInputArgs(inputArgs);
    }

    @Override
    public void run() {
        List<User> users = new ArrayList<>();
        User newUser = getUserService().getByUserName(getInputArgs().getUserName().get(0));
        users.add(newUser);

        getTaskService().create(new Task(users, getInputArgs().getTaskTittle(), getInputArgs().getDesc()));
//        System.out.println("AddTask start");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Add task finish");
    }
}
