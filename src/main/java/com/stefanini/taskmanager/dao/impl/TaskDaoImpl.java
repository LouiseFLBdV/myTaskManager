package com.stefanini.taskmanager.dao.impl;

import com.stefanini.taskmanager.dao.AbstractDao;
import com.stefanini.taskmanager.dao.TaskDao;
import com.stefanini.taskmanager.entities.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoImpl extends AbstractDao<Task> implements TaskDao {

    private TaskDaoImpl(){
    }

    @Override
    public Class<Task> getEntityClass() {
        return Task.class;
    }

}
