package com.stefanini.taskmanager.service.impl;

import com.stefanini.taskmanager.dao.TaskDao;
import com.stefanini.taskmanager.dao.TaskRepository;
import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.util.ConverterUtil;
import com.stefanini.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ConverterUtil converterUtil;

    public TaskServiceImpl(){ }

    @Override
    public TaskDTO getById(long id) {
        return converterUtil.convertToTaskDTO(taskRepository.getById(id));
    }

    @Override
    public List<TaskDTO> getAll() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> tasksDTO = new ArrayList<>();
        tasks.forEach(task -> {
            tasksDTO.add(converterUtil.convertToTaskDTO(task));
        });
        return tasksDTO;
    }

    @Override
    public TaskDTO save(TaskDTO task) {
        return converterUtil.convertToTaskDTO(taskRepository.save(converterUtil.convertToTaskEntity(task)));
    }

    @Override
    public void delete(TaskDTO task) {
        taskRepository.delete(converterUtil.convertToTaskEntity(task));
    }
}
