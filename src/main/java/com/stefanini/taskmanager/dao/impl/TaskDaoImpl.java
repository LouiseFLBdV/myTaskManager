package com.stefanini.taskmanager.dao.impl;

import com.stefanini.taskmanager.dao.AbstractDao;
import com.stefanini.taskmanager.dao.TaskDao;
import com.stefanini.taskmanager.entities.Task;
import org.hibernate.Session;

public class TaskDaoImpl extends AbstractDao<Task> implements TaskDao {
    private Session session;
    private static TaskDaoImpl taskDaoImpl;

    public TaskDaoImpl(){
    }

    public static synchronized TaskDaoImpl getTaskDaoImpl(){
        if (taskDaoImpl==null){
            taskDaoImpl = new TaskDaoImpl();
        }
        return taskDaoImpl;
    }

    @Override
    public Class<Task> getEntityClass() {
        return Task.class;
    }

}
