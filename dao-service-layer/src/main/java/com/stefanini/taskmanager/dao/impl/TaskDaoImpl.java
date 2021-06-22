package com.stefanini.taskmanager.dao.impl;

import com.stefanini.taskmanager.dao.AbstractDao;
import com.stefanini.taskmanager.dao.TaskDao;
import com.stefanini.taskmanager.entities.Task;

public class TaskDaoImpl extends AbstractDao<Task> implements TaskDao {
    private static TaskDaoImpl instance;

    private TaskDaoImpl(){
    }

    public static TaskDaoImpl getInstance(){
        if (instance ==null){
            instance = new TaskDaoImpl();
        }
        return instance;
    }

    @Override
    public Class<Task> getEntityClass() {
        return Task.class;
    }

}
