package com.stefanini.taskmanager;


import com.stefanini.taskmanager.operations.ApplicationLogic;
import com.stefanini.taskmanager.util.HibernateUtil;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
//        if (args.length == 0){
//            args = new String[]{"showTasks", "uN3"};
//            args = new String[]{"showAllUsers"};
//            args = new String[]{"addTask", "uN3", "task4", "task3 task3 task3 task3 task3"};
//            args = new String[]{"createUser", "firstName5" ,"lastName3", "userName3m2224432"};
//            args = new String[]{"createUser", "firstName3" ,"lastName3", "userName3"};
//        }

        ApplicationLogic applicationLogic = new ApplicationLogic();
//        args = new String[]{"showTasks", "uN3"};
        args = new String[]{"showAllUsers"};
        applicationLogic.execute(args);

        args = new String[]{"createUser", "fn=firstName1" ,"ln=lastName1", "un=userName1"};
        applicationLogic.execute(args);
        args = new String[]{"addTask", "un=userName1", "tt=task1", "td=task1desc"};
        applicationLogic.execute(args);
        args = new String[]{"showAllUsers"};
        applicationLogic.execute(args);

//        HibernateUtil.shutdown();
    }
}
