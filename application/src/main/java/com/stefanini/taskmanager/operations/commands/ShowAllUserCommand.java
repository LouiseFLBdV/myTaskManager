package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShowAllUserCommand extends AbstractCommand {

    public ShowAllUserCommand(){
        setCommandName("showallusers");
    }

    @Override
    public void execute() {
        List<User> users = getUserService().getAll();
        users.forEach(user -> {
                    getLogger().info("User: " + user.getUserName());
                    user.getTasks().forEach(task -> {
                        getLogger().info("\ttask " + task.getTaskTitle() + ":");
                        getLogger().info("\t\t" + task.getDescription());
                    });
                }
        );
    }
}
