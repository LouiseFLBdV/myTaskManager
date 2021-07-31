//package com.stefanini.taskmanager.commands;
//
//import com.stefanini.taskmanager.config.ConfigTest;
//import com.stefanini.taskmanager.dto.TaskDTO;
//import com.stefanini.taskmanager.model.InputModel;
//import com.stefanini.taskmanager.model.OutputModel;
//import com.stefanini.taskmanager.operations.commands.AddTaskCommand;
//import com.stefanini.taskmanager.service.TaskService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ConfigTest.class)
//public class AddTaskCommandTest {
//
//    @Autowired
//    private AddTaskCommand addTaskCommand;
//
//    @Autowired
//    private TaskService taskService;
//
//    private static final InputModel inputModel = new InputModel("", "testUserName", "testLastName", "testFirstName", "testTaskTittle", "testDesc");
//    private static final TaskDTO taskDTO = new TaskDTO(0, "testTaskTittle", "testDesc");
//
//    @Test
//    public void addTaskCommandShouldReturnOutputModel(){
//        when(taskService.create(any())).thenReturn(taskDTO);
//        OutputModel expectedOutputModel = new OutputModel();
//        expectedOutputModel.setTask(taskDTO);
//        addTaskCommand.setInputModel(inputModel);
//        assertEquals(expectedOutputModel.getTask(), addTaskCommand.execute().getTask());
//    }
//}
