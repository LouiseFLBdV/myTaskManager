package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.impl.TaskServiceImpl;
import com.stefanini.taskmanager.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractCommand implements Runnable{

    private static final Logger logger = LogManager.getLogger();
    private String commandName;
    private String[] args;
    private final TaskService taskService;
    private final UserService userService;

    AbstractCommand(){
        this.taskService = TaskServiceImpl.getInstance();
        this.userService = UserServiceImpl.getInstance();
    }
    /**
     * This method is used to execute the command
     */
    public abstract void run();
    /**
     * This method is used to get command name
     */
    public String getCommandName(){
        return commandName;
    }
    /**
     * This method is used to set command name
     */
    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }
    /**
     * This method is used to get parameters
     */
    public String[] getArgs() {
        return args;
    }
    /**
     * This method is used to set parameters
     */
    public void setArgs(String[] args) {
        this.args = args;
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
