package com.stefanini.taskmanager.service.impl;

import com.stefanini.taskmanager.dao.TaskDao;
import com.stefanini.taskmanager.dao.UserDao;
import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;
    private TaskDao taskDao;

    public UserServiceImpl(){ }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    @Transactional
    public UserDTO getById(long id) {
        return UserDTO.convertToDTO(userDao.getById(id));
    }

    @Override
    @Transactional
    public List<UserDTO> getAll() {
        List<User> users = userDao.getAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        users.forEach(user -> {
            usersDTO.add(UserDTO.convertToDTO(user));
        });
        return usersDTO;
    }

    @Override
    @Transactional
    public UserDTO create(UserDTO user) {
        return UserDTO.convertToDTO(userDao.create(convertToDAO(user)));
    }

    @Override
    @Transactional
    public void update(UserDTO user) {
        userDao.update(convertToDAO(user));
    }

    @Override
    @Transactional
    public void remove(UserDTO user) {
        userDao.delete(convertToDAO(user));
    }

    @Override
    @Transactional
    public UserDTO getByUserName(String userName) {
        return UserDTO.convertToDTO(userDao.getByUserName(userName));
    }

    //todo conv to entity
    //todo aparte
    public User convertToDAO(UserDTO user){
        User userEntity;
        if (user.getUserId()==0){
            userEntity = new User();
        }else{
            userEntity = userDao.getById(user.getUserId());
        }
        userEntity.setUserName(user.getUserName());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setTasks(user.getTasks().stream().map(task-> taskDao.getById(task.getTaskId())).collect(Collectors.toList()));
        return userEntity;
    }
}
