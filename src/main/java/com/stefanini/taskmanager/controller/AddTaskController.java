package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.model.OutputModel;
import com.stefanini.taskmanager.operations.commands.AddTaskCommand;
import com.stefanini.taskmanager.service.CommandService;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddTaskController {

    @Autowired
    CommandService commandService;

    @RequestMapping("/addTask")
    public String createUser(@ModelAttribute("inputModel") InputModel inputModel, Model model){
        OutputModel outputModel = new OutputModel();
        outputModel.setCommandName(inputModel.getCommandName());
        outputModel = commandService.execute(commandService.getAddTaskCommand(), inputModel);

        model.addAttribute("outputModel", outputModel);
        return "addTask";
    }
}
