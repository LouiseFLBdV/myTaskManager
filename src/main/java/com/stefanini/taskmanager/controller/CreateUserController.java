package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.model.OutputModel;
import com.stefanini.taskmanager.operations.commands.CreateUserCommand;
import com.stefanini.taskmanager.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateUserController {

    @Autowired
    CommandService commandService;

    @RequestMapping("/createUser")
    public String createUser(@ModelAttribute("inputModel") InputModel inputModel, Model model){
        OutputModel outputModel = new OutputModel();
        outputModel.setCommandName(inputModel.getCommandName());
        outputModel = commandService.execute(commandService.getCreateUserCommand(), inputModel);


        model.addAttribute("outputModel", outputModel);
        return "createUser";
    }
}
