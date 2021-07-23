package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.model.OutputModel;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowUsersCommand extends AbstractCommand {

    UserService userService;

    public ShowUsersCommand(){}

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }
    @Override
    public OutputModel execute() {
        OutputModel outputModel = new OutputModel();
        List<UserDTO> users = userService.getAll();
        users.forEach(this::showUsers);
        outputModel.setUsers(users);
        return outputModel;
    }

    @Override
    public void setInputModel(InputModel inputModel) {
        super.setInputModel(inputModel);
    }

    public void showUsers(UserDTO user){
        getLogger().info("User: " + user);
        if (user.getTasks().isEmpty()){
            user.getTasks().forEach(this::showTasks);
        }
    }

    public void showTasks(TaskDTO task){
        getLogger().info("\ttask " + task.getTaskTitle() + ":");
        getLogger().info("\t\t" + task.getDescription());
    }

}
