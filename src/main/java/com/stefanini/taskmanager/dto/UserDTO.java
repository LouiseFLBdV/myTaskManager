package com.stefanini.taskmanager.dto;

import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    private long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private List<TaskDTO> tasks = new ArrayList<>();

    public UserDTO() {
    }
    public UserDTO(long userId, String firstName, String lastName, String userName, List<TaskDTO> tasks) {
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

    public UserDTO(List<TaskDTO> tasks) {
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

    public List<TaskDTO> getTasks() {
        return tasks;
    }
    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public static UserDTO convertToDTO(User user){
        if (user==null){
            return null;
        }else {
            long userId = user.getId();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String userName = user.getUserName();
            List<TaskDTO> tasks = user.getTasks().stream().map(task -> {
                TaskDTO taskDTO = new TaskDTO();
                taskDTO.setTaskId(task.getId());
                taskDTO.setTaskTitle(task.getTaskTitle());
                taskDTO.setDescription(task.getDescription());
                return taskDTO;
            }).collect(Collectors.toList());
            return new UserDTO(userId, firstName, lastName, userName, tasks);
        }
    }
}