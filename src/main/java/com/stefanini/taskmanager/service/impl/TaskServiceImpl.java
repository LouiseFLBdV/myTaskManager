package com.stefanini.taskmanager.service.impl;

import com.stefanini.taskmanager.dao.TaskDao;
import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao;
    private UserDao userDao;

    TaskServiceImpl(){ }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public TaskDTO getById(long id) {
        return TaskDTO.convertToDTO(taskDao.getById(id));
    }

    @Override
    @Transactional
    public List<TaskDTO> getAll() {
        List<Task> users = taskDao.getAll();
        List<TaskDTO> tasksDTO = new ArrayList<>();
        users.forEach(task -> {
            tasksDTO.add(TaskDTO.convertToDTO(task));
        });
        return tasksDTO;
    }

    @Override
    @Transactional
    public TaskDTO create(TaskDTO task) {
        return TaskDTO.convertToDTO(taskDao.create(convertToDAO(task)));
    }

    @Override
    @Transactional
    public void update(TaskDTO task) {
        taskDao.update(convertToDAO(task));
    }

    @Override
    @Transactional
    public void remove(TaskDTO task) {
        taskDao.delete(convertToDAO(task));
    }

    public Task convertToDAO(TaskDTO task){
        Task taskEntity;
        if (task.getTaskId()==0){
            taskEntity = new Task();
        }else{
            taskEntity = taskDao.getById(task.getTaskId());
        }
        taskEntity.setTaskTitle(task.getTaskTitle());
        taskEntity.setDescription(task.getDescription());
        System.out.println("userId:" + task.getUsers().get(0));
        taskEntity.setUsers(task.getUsers().stream().map(user -> userDao.getById(user.getUserId())).collect(Collectors.toList()));
        return taskEntity;
    }
}
