package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
    @RequestMapping("/")
    public String welcome(Model model){
        model.addAttribute("inputModel", new InputModel());
        return "welcome";
    }

}
