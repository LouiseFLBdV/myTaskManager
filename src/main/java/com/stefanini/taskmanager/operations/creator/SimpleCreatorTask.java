package com.stefanini.taskmanager.operations.creator;

import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.impl.TaskServiceImpl;
import com.stefanini.taskmanager.service.impl.UserServiceImpl;

public class SimpleCreatorTask implements CreatorTask {
    private final String[] parameters;
    private String userName;
    private String taskTitle;
    private String taskDesc;

    public SimpleCreatorTask(String[] parameters){
        this.parameters = parameters;
    }

    @Override
    public void createTask() {
        this.userName = parameters[1].substring(4);
        this.taskTitle = parameters[2].substring(4);
        this.taskDesc = parameters[3].substring(4);
        UserService userService = new UserServiceImpl();
        TaskService taskService = new TaskServiceImpl();
        taskService.create(new Task(userService.userNameGet(userName), taskTitle, taskDesc));
    }
}
