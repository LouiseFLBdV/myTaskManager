package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShowUsersController {

    @Autowired
    private UserService userService;
    private static final Logger logger = LogManager.getLogger();

    @RequestMapping("/showUsers")
    public String createUser(Model model) {

        List<UserDTO> users = userService.getAll();
        users.forEach(this::showUsers);
        model.addAttribute("UserDTOList", users);
        return "showUsers";
    }

    public void showUsers(UserDTO user) {
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
