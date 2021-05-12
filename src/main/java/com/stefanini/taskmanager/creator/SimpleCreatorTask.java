package com.stefanini.taskmanager.creator;

import com.stefanini.taskmanager.dao.TaskDao;
import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.entities.Task;

public class SimpleCreatorTask implements CreatorTask {
    private final String userName;
    private final String taskTitle;
    private final String taskDesc;

    public SimpleCreatorTask(String[] args){

        this.userName = args[1].substring(4);
        this.taskTitle = args[2].substring(4);
        this.taskDesc = args[3].substring(4);
    }

    @Override
    public void createTask() {
        //TODO
        UserDao userDao = new UserDao();
        TaskDao taskDao = new TaskDao();
        taskDao.create(new Task(userDao.userNameGet(userName), taskTitle, taskDesc));
    }
}
