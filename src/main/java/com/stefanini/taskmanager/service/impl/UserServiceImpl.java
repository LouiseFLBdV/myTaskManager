package com.stefanini.taskmanager.service.impl;

import com.stefanini.taskmanager.dao.UserRepository;
import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.entities.User;
import com.stefanini.taskmanager.util.ConverterUtil;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConverterUtil converterUtil;
    public UserServiceImpl(){ }

    @Override
    public UserDTO getById(long id) {
        return converterUtil.convertToUserDTO(userRepository.getById(id));
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        users.forEach(user -> usersDTO.add(converterUtil.convertToUserDTO(user)));
        return usersDTO;
    }

    @Override
    public UserDTO save(UserDTO user) {
        return converterUtil.convertToUserDTO(userRepository.save(converterUtil.convertToUserEntity(user)));
    }

    @Override
    public void delete(UserDTO user) {
        userRepository.delete(converterUtil.convertToUserEntity(user));
    }

    @Override
    public UserDTO getByUserName(String userName) {
        UserDTO user = null;
        List<User> users = userRepository.findAll();
        Optional<User> optionalUser = users.stream().filter(u -> u.getUserName().equals(userName)).findFirst();
        if (optionalUser.isPresent()){
            user = converterUtil.convertToUserDTO(optionalUser.get());
        }
        return user;
    }
}
