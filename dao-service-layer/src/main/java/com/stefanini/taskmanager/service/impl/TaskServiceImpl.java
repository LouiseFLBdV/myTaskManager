package com.stefanini.taskmanager.service.impl;

import com.stefanini.taskmanager.dao.TaskDao;
import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.dao.factory.DaoFactory;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.service.EmailService;
import com.stefanini.taskmanager.service.TaskService;

import java.util.List;

import static com.stefanini.taskmanager.entities.DaoEntities.TASKDAO;

public class TaskServiceImpl implements TaskService {
    private static TaskServiceImpl INSTANCE;
    private TaskDao taskDao;

    private TaskServiceImpl(){
        if (taskDao==null){
            //todo add if null
            taskDao = (TaskDao) DaoFactory.getInstance().getDao(TASKDAO);
        }
    }

    public static synchronized TaskServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new TaskServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public List<Task> getAll() {
        return taskDao.getAll();
    }

    @Override
    public Task create(Task entity) {
        taskDao.create(entity);
        EmailService.sendEmail(entity);
        return entity;
    }

    @Override
    public Task update(Task entity) {
        taskDao.update(entity);
        return entity;
    }

    @Override
    public void remove(Task entity) {
        taskDao.delete(entity);
    }
}
