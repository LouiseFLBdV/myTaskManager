package com.stefanini.taskmanager.service.impl;

import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.service.AbstractService;
import com.stefanini.taskmanager.service.TaskService;

public class TaskServiceImpl extends AbstractService<Task> implements TaskService {
    @Override
    public Class<Task> getEntityClass() {
        return Task.class;
    }
}
