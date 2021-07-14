package com.stefanini.taskmanager.operations;

import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.operations.commands.*;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationLogic{
    @Autowired
    UserService userService;

    @Autowired
    CreateUserCommand createUserCommand;
    @Autowired
    ShowUsersCommand showUsersCommand;
    @Autowired
    AddTaskCommand addTaskCommand;
    @Autowired
    ShowUserTaskCommand showUserTaskCommand;

    public ApplicationLogic(){
    }

    public void execute(InputModel inputModel) {
        switch (inputModel.getCommandName()){
            case "createuser":
                createUserCommand.setInputModel(inputModel);
                createUserCommand.run();
                break;
            case "addtask":
                addTaskCommand.setInputModel(inputModel);
                addTaskCommand.run();
                break;
            case "showusers":
                showUsersCommand.setInputModel(inputModel);
                showUsersCommand.run();
                break;
            case "showusertask":
                showUserTaskCommand.setInputModel(inputModel);
                showUserTaskCommand.run();
                break;
        }
    }
}
