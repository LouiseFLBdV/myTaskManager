package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.model.OutputModel;
import com.stefanini.taskmanager.operations.commands.ShowUsersCommand;
import com.stefanini.taskmanager.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowUsersController {

    @Autowired
    private CommandService commandService;

    @RequestMapping("/showUsers")
    public String createUser(@ModelAttribute("inputModel") InputModel inputModel, Model model){
        OutputModel outputModel = new OutputModel();
        outputModel.setCommandName(inputModel.getCommandName());
        outputModel = commandService.execute(commandService.getShowUsersCommand(), inputModel);

        model.addAttribute("outputModel", outputModel);
        return "showUsers";
    }
}
