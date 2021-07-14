package com.stefanini.taskmanager.operations.commands;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddTaskCommand extends AbstractCommand {
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;

    public AddTaskCommand() {
    }

    @Override
    public void execute() {
        taskService.create(new Task(userService.getByUserName(getInputModel().getUserName()), getInputModel().getTaskTittle(), getInputModel().getDesc()));
    }

    @Override
    public void setInputModel(InputModel inputModel) {
        super.setInputModel(inputModel);
    }
}
