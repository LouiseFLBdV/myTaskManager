package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowUsersCommand extends AbstractCommand {

    public ShowUsersCommand(){
    }

    @Autowired
    UserService userService;

    @Override
    public void execute() {
        userService.getAll().forEach(this::showUsers);
    }

    public void showUsers(User user){
        getLogger().info("User: " + user.getUserName());
        if (user.getTasks().isEmpty()){
            user.getTasks().forEach(this::showTasks);
        }
    }

    public void showTasks(Task task){
        getLogger().info("\ttask " + task.getTaskTitle() + ":");
        getLogger().info("\t\t" + task.getDescription());
    }

    @Override
    public void setInputModel(InputModel inputModel) {
        super.setInputModel(inputModel);
    }
}
