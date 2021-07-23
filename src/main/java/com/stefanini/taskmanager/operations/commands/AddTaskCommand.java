package com.stefanini.taskmanager.operations.commands;
import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.model.OutputModel;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddTaskCommand extends AbstractCommand {
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;

    public AddTaskCommand() {
    }

    @Override
    public OutputModel execute() {
        OutputModel outputModel = new OutputModel();
        TaskDTO task = taskService.create(new TaskDTO(0,getInputModel().getTaskTittle(), getInputModel().getDesc(), userService.getByUserName(getInputModel().getUserName())));
        outputModel.setTask(task);
        return outputModel;
    }

    @Override
    public void setInputModel(InputModel inputModel) {
        super.setInputModel(inputModel);
    }
}
