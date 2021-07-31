package com.stefanini.taskmanager.dto;

import com.stefanini.taskmanager.entities.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskDTO {

    private long taskId;
    private String taskTitle;
    private String description;
    private List<UserDTO> users = new ArrayList<>();

    public TaskDTO() {
    }
    public TaskDTO(long taskId, String taskTitle, String description, List<UserDTO> users) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.description = description;
        this.users = users;
    }
    public TaskDTO(long taskId, String taskTitle, String description, UserDTO user) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.description = description;
        users.add(user);
    }

    public TaskDTO(long taskId, String taskTitle, String description) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.description = description;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
