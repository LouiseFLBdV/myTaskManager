//package com.stefanini.taskmanager.commands;
//
//
//import com.stefanini.taskmanager.config.ConfigTest;
//import com.stefanini.taskmanager.dto.UserDTO;
//import com.stefanini.taskmanager.model.InputModel;
//import com.stefanini.taskmanager.operations.commands.CreateUserCommand;
//import com.stefanini.taskmanager.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ConfigTest.class)
//public class CreateUserCommandTest {
//
//    @Autowired
//    private CreateUserCommand createUserCommand;
//
//    @Autowired
//    private UserService userService;
//
//    private static final InputModel inputModel = new InputModel("", "testUserName", "testLastName", "testFirstName", "testTaskTittle", "testDesc");
//
//    @Test
//    public void createUserCommandShouldNotCreateUserIfUserExist(){
//        when(userService.getByUserName(any())).thenReturn(new UserDTO());
//        when(userService.create(any())).thenReturn(new UserDTO());
//        createUserCommand.setInputModel(inputModel);
//        assertNull(createUserCommand.execute().getUser());
//    }
//}
