package com.stefanini.taskmanager.operations;

import com.stefanini.taskmanager.operations.commands.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//todo commit
//todo runnable de fi comenzile
public class ApplicationLogic implements Runnable{
    //todo модификаторы
    String commandName;
    List<AbstractCommand> abstractCommandList;
    //todo altfel
    public ApplicationLogic(String[] args){
        commandName = args[0].toLowerCase();
        args = Arrays.copyOfRange(args, 1, args.length);
        abstractCommandList = new ArrayList<>();
        abstractCommandList.add(new AddGroupTaskCommand(args));
        abstractCommandList.add(new AddTaskCommand(args));
        abstractCommandList.add(new CreateUserCommand(args));
        abstractCommandList.add(new ShowAllUserCommand());
        abstractCommandList.add(new ShowTaskCommand(args));
    }

    @Override
    public void run() {
        //todo aici argumente si de folosit cand trebue
        for (AbstractCommand abstractCommand : abstractCommandList) {

            if (abstractCommand.getCommandName().equals(commandName)) {
                abstractCommand.execute();
            }
        }
    }
}
