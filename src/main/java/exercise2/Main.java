package exercise2;

import exercise2.taskmanager.SimpleTaskManager;
import exercise2.taskmanager.TaskManager;

public class Main {
    public static void main(String[] args) {
        TaskManager simpleTaskManager = new SimpleTaskManager(args);
        simpleTaskManager.start();
    }
}
