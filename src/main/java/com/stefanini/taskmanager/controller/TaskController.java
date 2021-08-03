package com.stefanini.taskmanager.controller;

import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.exception_handling.ControllerException;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    public TaskController() {
    }

    @GetMapping("/tasks")
    public List<TaskDTO> getAllTasks(){
        return taskService.getAll();
    }

    @GetMapping("/tasks/{id}")
    public TaskDTO getById(@PathVariable int id){
        TaskDTO task = taskService.getById(id);
        if (task == null){
            throw new ControllerException("There is no task with id = " + id + " in Database");
        }
        return task;
    }

    @PostMapping("/tasks")
    public TaskDTO createTask(@RequestBody TaskDTO inputTask){
        TaskDTO task = null;
        if (inputTask.getUsers().size() > 1){
            task = taskService.save(inputTask);
        } else {
            if (inputTask.getUsers().isEmpty()){
                taskService.save(new TaskDTO(inputTask.getTitle(), inputTask.getDescription()));
            }else{
                task = taskService.save(new TaskDTO(inputTask.getTitle(), inputTask.getDescription(), userService.findByUserName(inputTask.getUsers().get(0).getUserName())));
            }
        }
        return task;
    }

    @PutMapping("/tasks")
    public void updateTask(@RequestBody TaskDTO inputTask){
        if (taskService.getById(inputTask.getTaskId())==null){
            throw new ControllerException("Can't update task with id  = " + inputTask.getTaskId() + " id, task not found in Database");
        }
        taskService.save(inputTask);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable int id){
        if (taskService.getById(id)==null){
            throw new ControllerException("Can't delete task with id = " + id +" id, task not found in Database");
        }
        taskService.delete(taskService.getById(id));
    }
}
