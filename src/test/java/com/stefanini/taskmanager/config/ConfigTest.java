package com.stefanini.taskmanager.config;

import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.mockito.Mockito.mock;

@Configuration
public class ConfigTest {

//    @Bean
//    public AddTaskCommand addTaskCommand(){
//        return new AddTaskCommand();
//    }
//    @Bean
//    public CreateUserCommand createUserCommand(){
//        return new CreateUserCommand();
//    }
//    @Bean
//    public ShowUserTaskCommand showUserTaskCommand(){
//        return new ShowUserTaskCommand();
//    }
//    @Bean
//    public ShowUsersCommand showUsersCommand(){
//        return new ShowUsersCommand();
//    }

    @Bean
    public UserService userService(){
        return mock(UserService.class);
    }

    @Bean
    public TaskService taskService(){
        return mock(TaskService.class);
    }
}
