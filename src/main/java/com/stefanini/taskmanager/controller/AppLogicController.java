package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.model.OutputModel;
import com.stefanini.taskmanager.operations.commands.AddTaskCommand;
import com.stefanini.taskmanager.operations.commands.CreateUserCommand;
import com.stefanini.taskmanager.operations.commands.ShowUserTaskCommand;
import com.stefanini.taskmanager.operations.commands.ShowUsersCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//todo service command
//todo url
@Controller
public class AppLogicController {
    @Autowired
    CreateUserCommand createUserCommand;
    @Autowired
    ShowUsersCommand showUsersCommand;
    @Autowired
    AddTaskCommand addTaskCommand;
    @Autowired
    ShowUserTaskCommand showUserTaskCommand;

    @RequestMapping("/appLogicController")
    public String applicationLogic(@ModelAttribute("inputModel") InputModel inputModel, Model model){
        OutputModel outputModel = new OutputModel();
        switch (inputModel.getCommandName()){
            case "createuser":
                createUserCommand.setInputModel(inputModel);
                outputModel = createUserCommand.execute();
                break;
            case "addtask":
                addTaskCommand.setInputModel(inputModel);
                outputModel = addTaskCommand.execute();
                break;
            case "showusers":
                showUsersCommand.setInputModel(inputModel);
                outputModel = showUsersCommand.execute();
                break;
            case "showusertask":
                showUserTaskCommand.setInputModel(inputModel);
                outputModel = showUserTaskCommand.execute();
                break;
        }
        outputModel.setCommandName(inputModel.getCommandName());
        model.addAttribute("outputModel", outputModel);
        return "appLogicController";
    }
}
