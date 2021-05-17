package com.stefanini.taskmanager.operations.displayer;

import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.impl.UserServiceImpl;

public class ConcreteDisplay implements Displayer {

    private final String userName;

    public ConcreteDisplay(String userName){
        this.userName = userName;
    }
    public void display() {
        UserService userService = new UserServiceImpl();
        User displayUser = userService.userNameGet(userName);
        System.out.println("User: " + displayUser.getUserName());
        displayUser.getTasks().forEach(task -> {
            System.out.println("\ttask " + task.getTaskTitle() + ":");
            System.out.println("\t\t" + task.getDescription());
        });
    }
}
