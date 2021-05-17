package com.stefanini.taskmanager.operations.displayer;

import com.stefanini.taskmanager.dao.impl.UserDaoImpl;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.impl.UserServiceImpl;

import java.util.List;

public class SimpleDisplay implements Displayer {

    public SimpleDisplay(){
    }
    @Override
    public void display() {
        UserService userService = new UserServiceImpl();
        List<User> displayUser = userService.getAll();
        displayUser.forEach(user -> {
            System.out.println("User: " + user.getUserName());
            user.getTasks().forEach(task -> {
                    System.out.println("\ttask " + task.getTaskTitle() + ":");
                    System.out.println("\t\t" + task.getDescription());
                });
                System.out.println("--------------------------");
            }
        );
    }
}
