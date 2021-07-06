package com.stefanini.taskmanager.dto;

import java.util.ArrayList;
import java.util.List;

public class InputArgs {
    String commandName;
    List<String> userName = new ArrayList<>();
    String lastName;
    String firstName;
    String taskTittle;
    String desc;

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public List<String> getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.add(userName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setUserName(List<String> userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTaskTittle() {
        return taskTittle;
    }

    public void setTaskTittle(String taskTittle) {
        this.taskTittle = taskTittle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "InputArgs{" +
                "commandName='" + commandName + '\'' +
                ", userName=" + userName +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", taskTittle='" + taskTittle + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
