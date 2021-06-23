package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.operations.ApplicationLogic;

public class ShowTaskCommand extends AbstractCommand {

    public ShowTaskCommand(String[] args){
        setCommandName("showtasks");
        setArgs(args);
    }

    @Override
    public void run() {

        User user = getUserService().getByUserName(getArgs()[0]);
        if (user!=null){
            getLogger().info("User: " + user.getUserName());
            if (!user.getTasks().isEmpty()){
                user.getTasks().forEach(task -> {
                    getLogger().info("\ttask " + task.getTaskTitle() + ":");
                    getLogger().info("\t\t" + task.getDescription());
                });
            }
        }else {
            getLogger().info("User " + getArgs()[0] + " not found");
        }
    }
}
