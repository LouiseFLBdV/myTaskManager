package com.stefanini.taskmanager.creator;

import com.stefanini.taskmanager.dao.TaskDao;
import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;

import java.util.List;

public class GroupCreatorTask implements CreatorTask {
    private String taskDesc;
    private String taskTitle;
    private String[] args;
    private List<User> users;

    public GroupCreatorTask(String[] args) {
        this.args = args;
        this.taskTitle = args[1].substring(4);
        this.taskDesc = args[2].substring(4);
    }

    @Override
    public void createTask() {
        UserDao userDao = new UserDao();
        TaskDao taskDao = new TaskDao();
        Task newTask = taskDao.create(new Task(taskTitle, taskDesc));
        for (int i = 3; i < args.length; i++){
            User newUser = userDao.userNameGet(args[i].substring(4));
            if (newUser!= null){
                newTask.addUser(newUser);
            }
        }
    }
}
