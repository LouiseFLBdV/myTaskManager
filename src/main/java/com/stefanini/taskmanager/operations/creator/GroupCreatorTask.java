package com.stefanini.taskmanager.operations.creator;

import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.impl.TaskServiceImpl;
import com.stefanini.taskmanager.service.impl.UserServiceImpl;

import java.util.List;

public class GroupCreatorTask implements CreatorTask {
    private final String[] parameters;

    public GroupCreatorTask(String[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public void createTask() {
        String taskTitle = parameters[1].substring(4);
        String taskDesc = parameters[2].substring(4);
        UserService userService = new UserServiceImpl();
        TaskService taskServiceImpl = new TaskServiceImpl();
        Task newTask = taskServiceImpl.create(new Task(taskTitle, taskDesc));
        for (int i = 3; i < parameters.length; i++){
            User newUser = userService.userNameGet(parameters[i].substring(4));
            if (newUser!= null){
                newTask.addUser(newUser);
            }
        }
    }
}
