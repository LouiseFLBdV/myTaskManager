package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowUserTaskController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LogManager.getLogger();

    @RequestMapping("/showUserTask")
    public String showUserTask(@ModelAttribute("inputModel") InputModel inputModel, Model model) {

        UserDTO user = userService.getByUserName(inputModel.getUserName());
        if (user != null) {
            showUser(userService.getByUserName(inputModel.getUserName()));
        } else {
            logger.info("User " + inputModel.getUserName() + " not found");
        }
        model.addAttribute("UserDTO", user);
        return "showUserTask";
    }

    @RequestMapping("/showUserTaskInput")
    public String createUserInput(@ModelAttribute("inputModel") InputModel inputModel, Model model) {
        model.addAttribute("inputModel", new InputModel());
        return "showUserTaskInput";
    }

    public void showUser(UserDTO user) {
        logger.info("User: " + user.getUserName());
        if (!user.getTasks().isEmpty()) {
            user.getTasks().forEach(this::showTasks);
        }
    }

    public void showTasks(TaskDTO task) {
        logger.info("\ttask " + task.getTaskTitle() + ":");
        logger.info("\t\t" + task.getDescription());
    }
}
