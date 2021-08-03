package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.exception_handling.ControllerException;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public UserDTO getById(@PathVariable int id){
        UserDTO user = userService.getById(id);
        if (user == null){
            throw new ControllerException("There is no user with id = " + id + " in Database");
        }
        return user;
    }

    @GetMapping("/users/byUserName/{userName}")
    public UserDTO getByUsername(@PathVariable String userName){
        UserDTO user = userService.getByUserName(userName);
        if (user == null){
            throw new ControllerException("There is no user with username = " + userName + " in Database");
        }
        return user;
    }

    @GetMapping("/users/{userName}/tasks")
    public List<TaskDTO> getTasks(@PathVariable String userName){
        if (userService.getByUserName(userName) == null){
            throw new ControllerException("There is no user with username = " + userName + " in Database");
        }
        UserDTO user = userService.getByUserName(userName);
        return user.getTasks();
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO inputUser){
        UserDTO user = null;
        if (userService.getByUserName(inputUser.getUserName()) == null) {
            user = userService.save(inputUser);
        }else {
            throw new ControllerException("User with username = " + inputUser.getUserName() + " already exist");
        }
        return user;
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody UserDTO inputUser){
        if (userService.getById(inputUser.getUserId())==null){
            throw new ControllerException("Can't update user with id = " + inputUser.getUserId() + " id, user not found in Database");
        }
        if (userService.getByUserName(inputUser.getUserName())!=null && userService.getByUserName(inputUser.getUserName()).getUserId()!=inputUser.getUserId()){
            throw new ControllerException("Can't update user with id = " + inputUser.getUserId() + " id, user with this userName already exist");
        }
        userService.save(inputUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        if (userService.getById(id)==null){
            throw new ControllerException("Can't delete user with id = " + id +" id, user not found in Database");
        }
        userService.delete(userService.getById(id));
    }
}
