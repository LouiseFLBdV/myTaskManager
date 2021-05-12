package com.stefanini.taskmanager.displayer;

import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.entities.User;

import java.util.List;

public class SimpleDisplay implements Displayer {

    public SimpleDisplay(){

    }
    @Override
    public void display() {
        UserDao userDao = new UserDao();
        List<User> displayUser = userDao.getAll();
        displayUser.forEach(user -> {
            System.out.println("User: " + user.getUserName());
            user.getTasks().forEach(task -> {
                    System.out.println("\ttask " + task.getTaskTitle() + ":");
                    System.out.println("\t\t" + task.getDescription());
                });
                System.out.println("--------------------------");
            }
        );
//        for (User user:myObject.getUsers()) {
//            System.out.println(user.getUserName() + " tasks:");
//            int temp = 1;
//            for (Task task:myObject.getTasks()) {
//                for (User userTask:task.getUsers()) {
//                    if (user.getUserName().equals(userTask.getUserName())){
//                        System.out.println("\ttask " + temp + ":");
//                        System.out.println("\t\t" + task.getTaskTitle());
//                        System.out.println("\t\t" + task.getDescription());
//                        temp++;
//                    }
//                }
//            }
//            if (temp==1){
//                System.out.println("haven't tasks");
//            }
//            System.out.println("--------------------------");
//        }
    }
}
