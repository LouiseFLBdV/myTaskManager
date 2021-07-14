package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.operations.commands.AddTaskCommand;
import com.stefanini.taskmanager.operations.commands.CreateUserCommand;
import com.stefanini.taskmanager.operations.commands.ShowUserTaskCommand;
import com.stefanini.taskmanager.operations.commands.ShowUsersCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/applicationLogic")
    public String applicationLogic(@ModelAttribute("inputModel") InputModel inputModel){
        switch (inputModel.getCommandName()){
            case "createuser":
                createUserCommand.setInputModel(inputModel);
                createUserCommand.execute();
                break;
            case "addtask":
                addTaskCommand.setInputModel(inputModel);
                addTaskCommand.execute();
                break;
            case "showusers":
                showUsersCommand.setInputModel(inputModel);
                showUsersCommand.execute();
                break;
            case "showusertask":
                showUserTaskCommand.setInputModel(inputModel);
                showUserTaskCommand.execute();
                break;
        }
        return "redirect:showUsers";
    }
}
