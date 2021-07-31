package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateUserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/createUser")
    public String createUser(@ModelAttribute("inputModel") InputModel inputModel, Model model){

        UserDTO user = null;
        if(userService.getByUserName(inputModel.getUserName())==null){
            user = userService.create(new UserDTO( 0, inputModel.getFirstName(), inputModel.getLastName(), inputModel.getUserName()));
        }

        model.addAttribute("UserDTO", user);
        return "createUser";
    }
}
