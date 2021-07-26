package com.stefanini.taskmanager.model;

import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class OutputModel {
    private TaskDTO task;
    private UserDTO user;
    private String commandName;
    private List<UserDTO> users = new ArrayList<>();

    public OutputModel() {
    }

    public OutputModel(TaskDTO task, UserDTO user, String commandName, List<UserDTO> users) {
        this.task = task;
        this.user = user;
        this.commandName = commandName;
        this.users = users;
    }

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }
}
