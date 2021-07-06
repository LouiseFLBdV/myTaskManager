package com.stefanini.taskmanager.operations;


import com.stefanini.taskmanager.dto.InputArgs;
import com.stefanini.taskmanager.operations.commands.*;
import com.stefanini.taskmanager.service.InputService;

import java.util.*;

import java.util.concurrent.*;

public class ApplicationLogic{
    private static final HashMap<InputArgs,CompletableFuture> completableFutureMap = new HashMap<>();
    private final List<CompletableFuture> waitToCompleteList = new ArrayList<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    public ApplicationLogic(){
    }

    public void execute(String[] args) {

        InputArgs inputArgs = InputService.getInputArgs(args);
        switch (inputArgs.getCommandName()){
            case "addgrouptask":
                completableFutureMap.put(inputArgs, CompletableFuture.runAsync(new AddGroupTaskCommand(inputArgs), executorService));
                break;
            case "addtask":
                completableFutureMap.keySet().forEach(key ->{
                    if (key.getCommandName().equals("createuser")){
                        if (key.getUserName().get(0).equals(inputArgs.getUserName().get(0))){
                            waitToCompleteList.add(completableFutureMap.get(key));
                        }
                    }
                });
                //не может принять колекцию
                completableFutureMap.put(inputArgs, CompletableFuture.allOf(waitToCompleteList.toArray(new CompletableFuture[waitToCompleteList.size()])).thenRunAsync(new AddTaskCommand(inputArgs), executorService));
                break;
            case "createuser":
                completableFutureMap.put(inputArgs, CompletableFuture.runAsync(new CreateUserCommand(inputArgs), executorService));
                break;
            case "showallusers":
//                CompletableFuture.allOf(stream.completableFutureMap);
                completableFutureMap.put(inputArgs, CompletableFuture.runAsync(new ShowAllUserCommand(inputArgs), executorService));
                break;
            case "showtasks":
                List<CompletableFuture> waitToCompleteList = new ArrayList<>();
                completableFutureMap.put(inputArgs, CompletableFuture.runAsync(new ShowTaskCommand(inputArgs), executorService));
                break;
        }
    }
}
