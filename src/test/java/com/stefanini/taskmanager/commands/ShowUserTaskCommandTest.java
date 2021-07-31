//package com.stefanini.taskmanager.commands;
//
//import com.stefanini.taskmanager.config.ConfigTest;
//import com.stefanini.taskmanager.dto.TaskDTO;
//import com.stefanini.taskmanager.dto.UserDTO;
//import com.stefanini.taskmanager.model.InputModel;
//import com.stefanini.taskmanager.operations.commands.ShowUserTaskCommand;
//import com.stefanini.taskmanager.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ConfigTest.class)
//public class ShowUserTaskCommandTest {
//
//    @Autowired
//    private ShowUserTaskCommand showUserTaskCommand;
//
//    @Autowired
//    private UserService userService;
//
//    private static final InputModel inputModel = new InputModel("", "", "", "", "", "");
//
//    //todo add verify method
//    @Test
//    public void showUserTaskCommandShouldReturnUserWithTaskIfHeHas(){
//        when(userService.getByUserName(any())).thenReturn(new UserDTO(new ArrayList<TaskDTO>(Arrays.asList(new TaskDTO(1, "taskTittle", "desc",new UserDTO())))));
//        showUserTaskCommand.setInputModel(inputModel);
//        assertEquals(showUserTaskCommand.execute().getUser().getTasks().size(), 1);
//    }
//}
