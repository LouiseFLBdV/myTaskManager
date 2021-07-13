package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.operations.ApplicationLogic;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String welcome(Model model){
        model.addAttribute("inputModel", new InputModel());
        return "welcome";
    }

    @RequestMapping("/showUsers")
    public String showUsers(Model model){
        List<User> users = userService.getAll();
        int userCount = users.size();
        int index = 0;
        model.addAttribute("users", users);
        model.addAttribute("userCount", userCount);
        model.addAttribute("index", index);
        return "showUsers";
    }
    @RequestMapping("/applicationLogic")
    public String applicationLogic(@ModelAttribute("inputModel") InputModel inputModel){
        ApplicationLogic applicationLogic = new ApplicationLogic();
        applicationLogic.execute(inputModel);
        return "applicationLogic";
    }
}
