package com.stefanini.taskmanager.operations;

import com.stefanini.taskmanager.operations.commands.*;

public class ApplicationLogic {
    String[] parameters;
    ApplicationCommands applicationCommands;

    public ApplicationLogic(String[] parameters){
        this.parameters = parameters;
        System.out.println(parameters.toString());
        applicationCommands = new ApplicationCommands(
                new AddGroupTaskCommand(parameters),
                new AddTaskCommand(parameters),
                new CreateUserCommand(parameters),
                new ShowAllUserCommand(),
                new ShowTaskCommand(parameters));
    }

    public void getCommand(){
        switch (parameters[0]){
            case "-createUser":
                applicationCommands.createUserCommand();
                break;
            case "-showAllUsers":
                applicationCommands.showAllUserCommand();
                break;
            case "-addTask":
                applicationCommands.addTaskCommand();
                break;
            case "-showTasks":
                applicationCommands.showTaskCommand();
                break;
            case "-addGroupTask":
                applicationCommands.addGroupTask();
                break;
            default:
                System.out.println(parameters[0]);
                System.out.println("-createUser|-showAllUsers|-addTask|-showTasks|-addGroupTask");
        }

    }
}
