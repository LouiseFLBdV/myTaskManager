package com.stefanini.taskmanager;

import com.stefanini.taskmanager.operations.ApplicationLogic;

public class Application {
    public static void main(String[] args) {
        if (args.length == 0){
            args = new String[]{"-showAllUsers"};
//            args = new String[]{"-addTask", "-tt=userName1", "-tt=task1", "-td=task1 task1 task1 task1 task1 task1 task1 task1"};
//            args = new String[]{"-createUser", "-fn=firstName3" ,"-ln=lastName3", "-un=userName3"};
//            args = new String[]{"-createUser", "-fn=firstName3" ,"-ln=lastName3", "-un=userName3"};
        }
        ApplicationLogic applicationLogic = new ApplicationLogic(args);
        applicationLogic.getCommand();
    }
}
