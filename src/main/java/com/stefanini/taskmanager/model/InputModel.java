package com.stefanini.taskmanager.model;

public class InputModel {
    private String commandName;
    private String userName;
    private String lastName;
    private String firstName;
    private String taskTittle;
    private String desc;

    public InputModel() {
    }

    public InputModel(String commandName, String userName, String lastName, String firstName, String taskTittle, String desc) {
        this.commandName = commandName;
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.taskTittle = taskTittle;
        this.desc = desc;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
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
        return "InputModel{" +
                "commandName='" + commandName + '\'' +
                ", userName=" + userName +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", taskTittle='" + taskTittle + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
