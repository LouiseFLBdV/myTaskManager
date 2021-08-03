package com.stefanini.taskmanager.util;

import com.stefanini.taskmanager.dao.TaskRepository;
import com.stefanini.taskmanager.dao.UserRepository;
import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConverterUtil {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public TaskDTO convertToTaskDTO(Task task){
        if (task==null){
            return null;
        }else{
            long taskId = task.getId();
            String taskTitle = task.getTaskTitle();
            String description = task.getDescription();
            List<UserDTO> users = task.getUsers().stream().map(user -> {
                UserDTO userDTO = new UserDTO();
                userDTO.setUserId(user.getId());
                userDTO.setUserName(user.getUserName());
                userDTO.setFirstName(user.getFirstName());
                userDTO.setLastName(user.getLastName());
                return userDTO;
            }).collect(Collectors.toList());
            return new TaskDTO(taskId, taskTitle, description, users);
        }
    }
    public UserDTO convertToUserDTO(User user){
        if (user==null){
            return null;
        }else {
            long userId = user.getId();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String userName = user.getUserName();
            List<TaskDTO> tasks = user.getTasks().stream().map(task -> {
                TaskDTO taskDTO = new TaskDTO();
                taskDTO.setTaskId(task.getId());
                taskDTO.setTitle(task.getTaskTitle());
                taskDTO.setDescription(task.getDescription());
                return taskDTO;
            }).collect(Collectors.toList());
            return new UserDTO(userId, firstName, lastName, userName, tasks);
        }
    }

    public Task convertToTaskEntity(TaskDTO task){
        Task taskEntity;
        if (task.getTaskId()==0){
            taskEntity = new Task();
        }else{
            taskEntity = taskRepository.getById(task.getTaskId());
        }
        taskEntity.setTaskTitle(task.getTitle());
        taskEntity.setDescription(task.getDescription());
        System.out.println(taskEntity);
        System.out.println(task.getUsers());
        taskEntity.setUsers(task.getUsers().stream().map(user -> {
            if (user.getUserId()==0) {
                Optional<User> optionalUser = userRepository.findAll().stream().filter(u -> u.getUserName().equals(user.getUserName())).findFirst();
                return optionalUser.orElse(null);
            }
            return userRepository.getById(user.getUserId());
        }).filter(Objects::nonNull).collect(Collectors.toList()));
        return taskEntity;
    }

    public User convertToUserEntity(UserDTO user){
        User userEntity;
        if (user.getUserId()==0){
            userEntity = new User();
        }else{
            userEntity = userRepository.getById(user.getUserId());
        }
        userEntity.setUserName(user.getUserName());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setTasks(user.getTasks().stream().map(task-> taskRepository.getById(task.getTaskId())).collect(Collectors.toList()));
        return userEntity;
    }
}
