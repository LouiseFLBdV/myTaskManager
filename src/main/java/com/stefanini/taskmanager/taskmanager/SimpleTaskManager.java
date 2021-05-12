package com.stefanini.taskmanager.taskmanager;

import com.stefanini.taskmanager.creator.*;
import com.stefanini.taskmanager.displayer.ConcreteDisplay;
import com.stefanini.taskmanager.displayer.Displayer;
import com.stefanini.taskmanager.displayer.SimpleDisplay;

public class SimpleTaskManager implements TaskManager {
    Displayer displayer;
    CreatorUser creatorUser;
    CreatorTask creatorTask;
    String[] args;
    public SimpleTaskManager(String[] args){
        this.args = args;
    }

    @Override
    public void start() {
        if (args.length == 0){
            args = new String[]{"-showAllUsers"};
//            args = new String[]{"-addTask", "-tt=userName1", "-tt=task1", "-td=task1 task1 task1 task1 task1 task1 task1 task1"};
//            args = new String[]{"-createUser", "-fn=firstName3" ,"-ln=lastName3", "-un=userName3"};
//            args = new String[]{"-createUser", "-fn=firstName3" ,"-ln=lastName3", "-un=userName3"};
        }
        args();
    }

    public void display(){ displayer.display(); }

    void args(){
        switch (args[0]){
            case "-createUser":
                creatorUser = new SimpleCreatorUser(args);
                creatorUser.createUser();
                break;
            case "-showAllUsers":
                displayer = new SimpleDisplay();
                display();
                break;
            case "-addTask":
                creatorTask = new SimpleCreatorTask(args);
                creatorTask.createTask();
                break;
            case "-showTasks":
                displayer = new ConcreteDisplay(args[1].substring(4));
                display();
                break;
            case "-addGroupTask":
                creatorTask = new GroupCreatorTask(args);
                creatorTask.createTask();
                break;
            default:
                System.out.println(args[0]);
                System.out.println("-createUser|-showAllUsers|-addTask|-showTasks|-addGroupTask");
        }
    }
}
