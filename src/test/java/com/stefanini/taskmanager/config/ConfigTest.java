package com.stefanini.taskmanager.config;

import com.stefanini.taskmanager.dto.TaskDTO;
import com.stefanini.taskmanager.operations.commands.AddTaskCommand;
import com.stefanini.taskmanager.operations.commands.CreateUserCommand;
import com.stefanini.taskmanager.operations.commands.ShowUserTaskCommand;
import com.stefanini.taskmanager.operations.commands.ShowUsersCommand;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.transaction.BeforeTransaction;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Configuration
public class ConfigTest {

    @Bean
    public AddTaskCommand addTaskCommand(){
        return new AddTaskCommand();
    }
    @Bean
    public CreateUserCommand createUserCommand(){
        return new CreateUserCommand();
    }
    @Bean
    public ShowUserTaskCommand showUserTaskCommand(){
        return new ShowUserTaskCommand();
    }
    @Bean
    public ShowUsersCommand showUsersCommand(){
        return new ShowUsersCommand();
    }

    @Bean
    public UserService userService(){
        return mock(UserService.class);
    }

    @Bean
    public TaskService taskService(){
        return mock(TaskService.class);
    }
}
