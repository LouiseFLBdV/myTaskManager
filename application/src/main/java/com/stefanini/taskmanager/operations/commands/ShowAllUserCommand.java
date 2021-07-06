package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.dto.InputArgs;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import java.util.List;

public class ShowAllUserCommand extends AbstractCommand {

    public ShowAllUserCommand(InputArgs inputArgs){
        setInputArgs(inputArgs);
    }

    @Override
    public void run() {
        List<User> users = getUserService().getAll();
        for (User user:users){
            getLogger().info("User: " + user.getUserName());
            if (user.getTasks()!=null){
                for (Task task: user.getTasks()){
                    getLogger().info("\ttask " + task.getTaskTitle() + ":");
                    getLogger().info("\t\t" + task.getDescription());
                }
            }
        }

//        System.out.println("Show ALL user start");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Show all user finish");
    }
}
