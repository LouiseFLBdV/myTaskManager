package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.dto.InputArgs;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.operations.ApplicationLogic;

public class ShowTaskCommand extends AbstractCommand {

    public ShowTaskCommand(InputArgs inputArgs){
        setInputArgs(inputArgs);
    }

    @Override
    public void run() {
//        User user = getUserService().getByUserName(getInputArgs().getUserName().get(0));
//        if (user!=null){
//            getLogger().info("User: " + user.getUserName());
//            if (!user.getTasks().isEmpty()){
//                user.getTasks().forEach(task -> {
//                    getLogger().info("\ttask " + task.getTaskTitle() + ":");
//                    getLogger().info("\t\t" + task.getDescription());
//                });
//            }
//        }else {
//            getLogger().info("User " + getInputArgs().getUserName().get(0) + " not found");
//        }
        System.out.println("Show task start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ShowTask finish");
    }
}
