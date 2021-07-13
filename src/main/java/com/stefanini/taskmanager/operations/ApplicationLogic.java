package com.stefanini.taskmanager.operations;

import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.operations.commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationLogic{
    private static final HashMap<InputModel,CompletableFuture> completableFutureMap = new HashMap<>();
    private final List<CompletableFuture> waitToCompleteList = new ArrayList<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    public ApplicationLogic(){
    }

    public void execute(InputModel inputModel) {
        System.out.println(inputModel);
        System.out.println("hahaha");
        switch (inputModel.getCommandName()){
            case "addtask":
                completableFutureMap.keySet().forEach(key ->{
                    if (key.getCommandName().equals("createuser")){
                        if (key.getUserName().get(0).equals(inputModel.getUserName().get(0))){
                            waitToCompleteList.add(completableFutureMap.get(key));
                        }
                    }
                });
                completableFutureMap.put(inputModel, CompletableFuture.allOf(waitToCompleteList.toArray(new CompletableFuture[waitToCompleteList.size()])).thenRunAsync(new AddTaskCommand(inputModel), executorService));
                break;
            case "createuser":
                completableFutureMap.put(inputModel, CompletableFuture.runAsync(new CreateUserCommand(inputModel), executorService));
                System.out.println("userCreated");
                System.out.println(completableFutureMap);
                break;
            case "showallusers":
                completableFutureMap.put(inputModel, CompletableFuture.runAsync(new ShowAllUserCommand(inputModel), executorService));
                break;
            case "showtasks":
                completableFutureMap.put(inputModel, CompletableFuture.runAsync(new ShowTaskCommand(inputModel), executorService));
                break;
        }
    }
}
