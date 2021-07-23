package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.model.InputModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String welcome(Model model){
        model.addAttribute("inputModel", new InputModel());
        return "welcome";
    }

}
