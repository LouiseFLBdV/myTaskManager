package com.stefanini.taskmanager.dto;

import java.util.ArrayList;
import java.util.List;

public class TaskDTO {

    private long taskId;
    private String title;
    private String description;
    private List<UserDTO> users = new ArrayList<>();

    public TaskDTO() {
    }
    public TaskDTO(long taskId, String title, String description, List<UserDTO> users) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.users = users;
    }
    public TaskDTO(String title, String description, UserDTO user) {
        this.title = title;
        this.description = description;
        users.add(user);
    }
    public TaskDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                '}';
    }
}
