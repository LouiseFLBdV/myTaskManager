package com.stefanini.taskmanager.service.impl;

import com.stefanini.taskmanager.dao.TaskDao;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao;

    @Autowired
    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    @Transactional
    public List<Task> getAll() {
        return taskDao.getAll();
    }

    @Override
    @Transactional
    public Task create(Task entity) {
        taskDao.create(entity);
        return entity;
    }

    @Override
    @Transactional
    public Task update(Task entity) {
        taskDao.update(entity);
        return entity;
    }

    @Override
    @Transactional
    public void remove(Task entity) {
        taskDao.delete(entity);
    }
}
