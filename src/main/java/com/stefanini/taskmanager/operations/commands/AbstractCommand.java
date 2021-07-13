package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.impl.TaskServiceImpl;
import com.stefanini.taskmanager.service.impl.UserServiceImpl;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

public abstract class AbstractCommand implements Runnable{

    private static final Logger logger = LogManager.getLogger();
    private InputModel inputModel;
    private TaskService taskService;
    private UserService userService;

    AbstractCommand(){
         this.userService = new UserServiceImpl();
         this.taskService = new TaskServiceImpl();
    }
    /**
     * This method is used to execute the command
     */
    public abstract void run();

    public InputModel getInputModel() {
        return inputModel;
    }

    public void setInputModel(InputModel inputModel) {
        this.inputModel = inputModel;
    }

    /**
     * This method is used to get task service
     */
    public TaskService getTaskService() {
        return taskService;
    }
    /**
     * This method is used to get set service
     */
    public UserService getUserService() {
        return userService;
    }
    /**
     * This method is used to get Logger
     */
    public static Logger getLogger() {
        return logger;
    }
}
