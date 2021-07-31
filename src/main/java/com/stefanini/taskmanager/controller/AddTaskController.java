package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddTaskController {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @RequestMapping("/addTask")
    public String createUser(@ModelAttribute("inputModel") InputModel inputModel, Model model){

        TaskDTO task = taskService.create(new TaskDTO(0,inputModel.getTaskTittle(), inputModel.getDesc(), userService.getByUserName(inputModel.getUserName())));

        model.addAttribute("TaskDTO", task);
        return "addTask";
    }
}
