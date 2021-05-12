package com.stefanini.taskmanager;

import com.stefanini.taskmanager.dao.TaskDao;
import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.displayer.Displayer;
import com.stefanini.taskmanager.displayer.SimpleDisplay;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.taskmanager.SimpleTaskManager;
import com.stefanini.taskmanager.taskmanager.TaskManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskManager simpleTaskManager = new SimpleTaskManager(args);
        simpleTaskManager.start();
    }
}
