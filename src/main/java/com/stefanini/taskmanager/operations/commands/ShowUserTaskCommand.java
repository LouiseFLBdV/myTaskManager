package com.stefanini.taskmanager.operations.commands;


import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.model.OutputModel;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowUserTaskCommand extends AbstractCommand {
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;

    public ShowUserTaskCommand(){
    }

    @Override
    public OutputModel execute() {
        OutputModel outputModel = new OutputModel();
        User user = userService.getByUserName(getInputModel().getUserName());
        outputModel.setUser(user);
        if (user!=null){
            showUser(userService.getByUserName(getInputModel().getUserName()));
        }else {
            getLogger().info("User " + getInputModel().getUserName() + " not found");
        }
        return outputModel;
    }

    public void showUser(User user){
        getLogger().info("User: " + user.getUserName());
        if (!user.getTasks().isEmpty()){
            user.getTasks().forEach(this::showTasks);
        }
    }

    public void showTasks(Task task){
        getLogger().info("\ttask " + task.getTaskTitle() + ":");
        getLogger().info("\t\t" + task.getDescription());
        System.out.println("\ttask " + task.getTaskTitle() + ":");
        System.out.println("\t\t" + task.getDescription());
    }

    @Override
    public void setInputModel(InputModel inputModel) {
        super.setInputModel(inputModel);
    }
}
