package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.model.OutputModel;
import com.stefanini.taskmanager.operations.commands.ShowUserTaskCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowUserTaskController {
    @Autowired
    ShowUserTaskCommand showUserTaskCommand;

    @RequestMapping("/showUserTask")
    public String createUser(@ModelAttribute("inputModel") InputModel inputModel, Model model){
        OutputModel outputModel = new OutputModel();
        outputModel.setCommandName(inputModel.getCommandName());
        showUserTaskCommand.setInputModel(inputModel);
        outputModel = showUserTaskCommand.execute();

        model.addAttribute("outputModel", outputModel);
        return "showUserTask";
    }
}
