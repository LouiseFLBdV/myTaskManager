package com.stefanini.taskmanager.service.impl;

import com.stefanini.taskmanager.dao.TaskDao;
import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.util.ConverterEntityDTO;
import com.stefanini.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private ConverterEntityDTO converterEntityDTO;

    public TaskServiceImpl(){ }

    @Override
    public TaskDTO getById(long id) {
        return converterEntityDTO.convertToTaskDTO(taskDao.getById(id));
    }

    @Override
    @Transactional
    public List<TaskDTO> getAll() {
        List<Task> users = taskDao.getAll();
        List<TaskDTO> tasksDTO = new ArrayList<>();
        users.forEach(task -> {
            tasksDTO.add(converterEntityDTO.convertToTaskDTO(task));
        });
        return tasksDTO;
    }

    @Override
    @Transactional
    public TaskDTO create(TaskDTO task) {
        return converterEntityDTO.convertToTaskDTO(taskDao.create(converterEntityDTO.convertToTaskEntity(task)));
    }

    @Override
    @Transactional
    public void update(TaskDTO task) {
        taskDao.update(converterEntityDTO.convertToTaskEntity(task));
    }

    @Override
    @Transactional
    public void remove(TaskDTO task) {
        taskDao.delete(converterEntityDTO.convertToTaskEntity(task));
    }
}
