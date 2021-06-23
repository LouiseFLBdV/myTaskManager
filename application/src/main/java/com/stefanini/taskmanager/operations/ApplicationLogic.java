package com.stefanini.taskmanager.operations;


import com.stefanini.taskmanager.operations.commands.*;

import java.util.Arrays;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ApplicationLogic{
    private String commandName;
    private String[] commandArgs;
    private static int tempCreateUser = 0;
    private static int tempOperations = 0;
    ExecutorService executorService = Executors.newFixedThreadPool(4);

    public ApplicationLogic(){
    }

    public static int getTempCreateUser() {
        return tempCreateUser;
    }

    public static void setTempCreateUser(int tempCreateUser) {
        ApplicationLogic.tempCreateUser = tempCreateUser;
    }

    public static int getTempOperations() {
        return tempOperations;
    }

    public static void setTempOperations(int tempOperations) {
        ApplicationLogic.tempOperations = tempOperations;
    }

    public void execute(String[] args) {
        commandName = args[0].toLowerCase();
        commandArgs = Arrays.copyOfRange(args, 1, args.length);
        switch (commandName){
            case "addgrouptask":
                tempOperations++;
                executorService.execute(new AddGroupTaskCommand(commandArgs));
                break;
            case "addtask":
                tempOperations++;
                while (tempCreateUser>0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                executorService.execute(new AddTaskCommand(commandArgs));

                break;
            case "createuser":
                tempCreateUser++;
                tempOperations++;
                executorService.execute(new CreateUserCommand(commandArgs));

            case "showallusers":
                executorService.execute(new ShowAllUserCommand());
                break;
            case "showtasks":
                while (tempOperations > 0 && tempCreateUser > 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                executorService.execute(new ShowTaskCommand(commandArgs));
                break;
        }

    }
}
