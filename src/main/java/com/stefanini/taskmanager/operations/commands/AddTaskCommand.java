package com.stefanini.taskmanager.operations.commands;
import com.stefanini.taskmanager.entities.Task;
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
        Task task = taskService.create(new Task(userService.getByUserName(getInputModel().getUserName()), getInputModel().getTaskTittle(), getInputModel().getDesc()));
        outputModel.setTask(task);
        return outputModel;
    }

    @Override
    public void setInputModel(InputModel inputModel) {
        super.setInputModel(inputModel);
    }
}
