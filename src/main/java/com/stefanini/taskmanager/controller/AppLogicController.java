package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.model.InputModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

//service
@Controller
public class AppLogicController {

    @RequestMapping("/appLogicController")
    public RedirectView applicationLogic(@ModelAttribute("inputModel") InputModel inputModel, RedirectAttributes redirectAttributes){
        RedirectView redirectView = new RedirectView("/applicationLogic",true);
        redirectAttributes.addFlashAttribute("inputModel", inputModel);
        switch (inputModel.getCommandName()){
            case "createuser":
                redirectView = new RedirectView("/createUser",true);
                break;
            case "addtask":
                redirectView = new RedirectView("/addTask",true);
                break;
            case "showusers":
                redirectView = new RedirectView("/showUsers",true);
                break;
            case "showusertask":
                redirectView = new RedirectView("/showUserTask",true);
                break;
        }
        return redirectView;
    }
}
