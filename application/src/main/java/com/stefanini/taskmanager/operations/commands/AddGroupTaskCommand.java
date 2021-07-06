package com.stefanini.taskmanager.operations.commands;
import com.stefanini.taskmanager.dto.InputArgs;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.operations.ApplicationLogic;

import java.util.ArrayList;
import java.util.List;

public class AddGroupTaskCommand extends AbstractCommand {

    public AddGroupTaskCommand(InputArgs inputArgs) {
        setInputArgs(inputArgs);
    }

    @Override
    public void run() {

        List<User> users = new ArrayList<>();

        for (int i = 3; i < getInputArgs().getUserName().size(); i++){
            User newUser = getUserService().getByUserName(getInputArgs().getUserName().get(i));
            if (newUser!= null){
                if(users.contains(newUser)){
                    getLogger().warn(newUser + " is already exist");
                }else{
                    users.add(newUser);
                }
            }
        }

        getTaskService().create(new Task(users, getInputArgs().getTaskTittle(), getInputArgs().getDesc()));
//        System.out.println("Add group start");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Add group finish");
    }
}
