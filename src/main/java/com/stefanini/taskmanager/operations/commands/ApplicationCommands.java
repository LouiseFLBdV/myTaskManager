package com.stefanini.taskmanager.operations.commands;

public class ApplicationCommands {
    Command addGroupTask;
    Command addTaskCommand;
    Command createUserCommand;
    Command showAllUserCommand;
    Command showTaskCommand;

    public ApplicationCommands(Command addGroupTask, Command addTaskCommand, Command createUserCommand, Command showAllUserCommand, Command showTaskCommand) {
        this.addGroupTask = addGroupTask;
        this.addTaskCommand = addTaskCommand;
        this.createUserCommand = createUserCommand;
        this.showAllUserCommand = showAllUserCommand;
        this.showTaskCommand = showTaskCommand;
    }

    public void addGroupTask(){
        addGroupTask.command();
    }
    public void addTaskCommand(){
        addTaskCommand.command();
    }
    public void createUserCommand(){
        createUserCommand.command();
    }
    public void showAllUserCommand(){
        showAllUserCommand.command();
    }
    public void showTaskCommand(){
        showTaskCommand.command();
    }
}
