package com.stefanini.taskmanager.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private List<com.stefanini.taskmanager.dto.TaskDTO> tasks = new ArrayList<>();

    public UserDTO() {
    }
    public UserDTO(long userId, String firstName, String lastName, String userName, List<com.stefanini.taskmanager.dto.TaskDTO> tasks) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.tasks = tasks;
    }
    public UserDTO(long userId, String firstName, String lastName, String userName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }
    public UserDTO(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public UserDTO(List<com.stefanini.taskmanager.dto.TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<com.stefanini.taskmanager.dto.TaskDTO> getTasks() {
        return tasks;
    }
    public void setTasks(List<com.stefanini.taskmanager.dto.TaskDTO> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}