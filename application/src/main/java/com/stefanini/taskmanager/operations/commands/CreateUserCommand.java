package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.dto.InputArgs;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.operations.ApplicationLogic;

public class CreateUserCommand extends AbstractCommand {

    public CreateUserCommand(InputArgs inputArgs){
        setInputArgs(inputArgs);
    }

    @Override
    public void run() {
        if(getUserService().getByUserName(getInputArgs().getUserName().get(0))==null){
            getUserService().create(new User(getInputArgs().getFirstName(), getInputArgs().getLastName(), getInputArgs().getUserName().get(0)));
        }else{
            getLogger().warn("User " + getInputArgs().getUserName().get(0) + " already exist");
        }
//        System.out.println("CreateUser start");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("CreateUser finish");
    }
}
