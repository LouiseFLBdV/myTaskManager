package com.stefanini.taskmanager.commands;

import com.stefanini.taskmanager.config.ConfigTest;
import com.stefanini.taskmanager.dto.UserDTO;
import com.stefanini.taskmanager.model.InputModel;
import com.stefanini.taskmanager.operations.commands.ShowUsersCommand;
import com.stefanini.taskmanager.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ConfigTest.class)
public class ShowUsersCommandTest {

    @Autowired
    private ShowUsersCommand showUsersCommand;

    @Autowired
    private UserService userService;

    private static final InputModel inputModel = new InputModel("", "", "", "", "", "");

    @Test
    public void showUsersCommandShouldReturnValueIfInputModelIsEmpty(){
        when(userService.getAll()).thenReturn(new ArrayList<UserDTO>(Arrays.asList(new UserDTO(), new UserDTO())));
        showUsersCommand.setInputModel(inputModel);
        assertEquals(showUsersCommand.execute().getUsers().size(), 2);
    }
}
