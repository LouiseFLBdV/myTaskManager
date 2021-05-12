package com.stefanini.taskmanager.displayer;

import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.entities.User;

public class ConcreteDisplay implements Displayer {

    private final String userName;
    public ConcreteDisplay(String userName){
        this.userName = userName;
    }

    public void display() {
        UserDao userDao = new UserDao();
        User displayUser = userDao.userNameGet(userName);
        System.out.println("User: " + displayUser.getUserName());
        displayUser.getTasks().forEach(task -> {
            System.out.println("\ttask " + task.getTaskTitle() + ":");
            System.out.println("\t\t" + task.getDescription());
        });
//        for (User user:myObject.getUsers()) {
//            if (user.getUserName().equals(userName)){
//                System.out.println(user.getUserName() + " tasks:");
//                int temp = 1;
//                for (Task task:myObject.getTasks()) {
//                    for (User userTask:task.getUsers()) {
//                        if (user.getUserName().equals(userTask.getUserName())){
//                            System.out.println("\ttask " + temp + ":");
//                            System.out.println("\t\t" + task.getTaskTitle());
//                            System.out.println("\t\t" + task.getDescription());
//                            temp++;
//                        }
//                    }
//                }
//                if (temp==1){
//                    System.out.println("haven't tasks");
//                }
//                System.out.println("--------------------------");
//            }
//        }
    }
}
