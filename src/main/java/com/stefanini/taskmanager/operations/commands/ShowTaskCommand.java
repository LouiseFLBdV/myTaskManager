package com.stefanini.taskmanager.operations.commands;


import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.model.InputModel;

public class ShowTaskCommand extends AbstractCommand {

    public ShowTaskCommand(InputModel inputModel){
        setInputModel(inputModel);
    }

    @Override
    public void run() {
        User user = getUserService().getByUserName(getInputModel().getUserName().get(0));
        if (user!=null){
            getLogger().info("User: " + user.getUserName());
            if (!user.getTasks().isEmpty()){
                user.getTasks().forEach(task -> {
                    getLogger().info("\ttask " + task.getTaskTitle() + ":");
                    getLogger().info("\t\t" + task.getDescription());
                });
            }
        }else {
            getLogger().info("User " + getInputModel().getUserName().get(0) + " not found");
        }
    }
}
