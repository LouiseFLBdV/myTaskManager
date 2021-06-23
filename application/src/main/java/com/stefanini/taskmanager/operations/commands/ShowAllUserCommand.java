package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShowAllUserCommand extends AbstractCommand {

    public ShowAllUserCommand(){
        setCommandName("showallusers");
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
    }
}
