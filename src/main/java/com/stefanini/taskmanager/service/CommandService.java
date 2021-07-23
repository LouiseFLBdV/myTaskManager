package com.stefanini.taskmanager.service;

import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.model.OutputModel;
import com.stefanini.taskmanager.operations.commands.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandService {
    private CreateUserCommand createUserCommand;
    private AddTaskCommand addTaskCommand;
    private ShowUsersCommand showUsersCommand;
    private ShowUserTaskCommand showUserTaskCommand;

    public CommandService() {
    }

    @Autowired
    public void setCreateUserCommand(CreateUserCommand createUserCommand) {
        this.createUserCommand = createUserCommand;
    }

    @Autowired
    public void setAddTaskCommand(AddTaskCommand addTaskCommand) {
        this.addTaskCommand = addTaskCommand;
    }

    @Autowired
    public void setShowUsersCommand(ShowUsersCommand showUsersCommand) {
        this.showUsersCommand = showUsersCommand;
    }

    @Autowired
    public void setShowUserTaskCommand(ShowUserTaskCommand showUserTaskCommand) {
        this.showUserTaskCommand = showUserTaskCommand;
    }

    public CreateUserCommand getCreateUserCommand() {
        return createUserCommand;
    }

    public AddTaskCommand getAddTaskCommand() {
        return addTaskCommand;
    }

    public ShowUsersCommand getShowUsersCommand() {
        return showUsersCommand;
    }

    public ShowUserTaskCommand getShowUserTaskCommand() {
        return showUserTaskCommand;
    }

    public OutputModel execute(AbstractCommand command, InputModel inputModel){
        command.setInputModel(inputModel);
        return command.execute();
    }
}
