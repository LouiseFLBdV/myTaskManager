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


//        ApplicationLogic applicationLogic0 = new ApplicationLogic(args);
////        executorService.execute(applicationLogic0);
////
//                    args = new String[]{"showTasks", "uN3"};
//        ApplicationLogic applicationLogic2 = new ApplicationLogic(args);
//        executorService.execute(applicationLogic2);
//        ApplicationLogic applicationLogic3 = new ApplicationLogic(args);
//        executorService.execute(applicationLogic0);
//        ApplicationLogic applicationLogic1 = new ApplicationLogic(args);
//        executorService.execute(applicationLogic1);

//        HibernateUtil.shutdown();
//        executorService.shutdown();

//        ApplicationLogic applicationLogic0 = new ApplicationLogic(args);
//        applicationLogic0.run();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String userName;
            String firstName;
            String lastName;
            String taskTitle;
            String taskDesc;
            String temp;
            System.out.println("-------------------------------------");
            System.out.println("0) show all user");
            System.out.println("1) Create user");
            System.out.println("2) add Task to user");
            System.out.println("3) add Task and User");
            System.out.println("4) show user");
            System.out.println("5) shutdown");
            System.out.println("-------------------------------------");
            System.out.print("--->");
            temp = scanner.nextLine();
            if (temp.equals("0")) {
                args = new String[]{"showAllUsers"};
                executorService.execute(new ApplicationLogic(args));
            }else if (temp.equals("1")){
                System.out.println("Create user: ");
                System.out.print("userName ---> ");
                userName = scanner.nextLine();
                System.out.print("firstName---> ");
                firstName = scanner.nextLine();
                System.out.print("lastName ---> ");
                lastName = scanner.nextLine();
                args = new String[]{"createUser", firstName, lastName, userName};
                executorService.execute(new ApplicationLogic(args));
            }else if(temp.equals("2")) {
                System.out.println("addTask to user");
                System.out.print("userName   ---> ");
                userName = scanner.nextLine();
                System.out.print("taskTittle ---> ");
                taskTitle = scanner.nextLine();
                System.out.print("taskDesc   ---> ");
                taskDesc = scanner.nextLine();

                args = new String[]{"addTask", userName, taskTitle, taskDesc};
                executorService.execute(new ApplicationLogic(args));
            }else if(temp.equals("3")) {

                System.out.println("addTask and user");
                System.out.print("userName   ---> ");
                userName = scanner.nextLine();
                System.out.print("firstName---> ");
                firstName = scanner.nextLine();
                System.out.print("lastName ---> ");
                lastName = scanner.nextLine();
                System.out.print("taskTittle ---> ");
                taskTitle = scanner.nextLine();
                System.out.print("taskDesc   ---> ");
                taskDesc = scanner.nextLine();

                args = new String[]{"createUser", firstName, lastName, userName};
                executorService.execute(new ApplicationLogic(args));
                args = new String[]{"addTask", userName, taskTitle, taskDesc};
                executorService.execute(new ApplicationLogic(args));
            }else if (temp.equals("4")){
                System.out.print("userName   ---> ");
                userName = scanner.nextLine();
                args = new String[]{"showtasks", userName};
                executorService.execute(new ApplicationLogic(args));
            }else if (temp.equals("5")){
                break;
            }
        }
    }
}
