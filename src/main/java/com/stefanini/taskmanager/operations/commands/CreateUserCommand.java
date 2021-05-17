package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.operations.creator.CreatorUser;
import com.stefanini.taskmanager.operations.creator.SimpleCreatorUser;

public class CreateUserCommand implements Command{
    CreatorUser creatorUser;

    public CreateUserCommand(String[] parameters){
        creatorUser = new SimpleCreatorUser(parameters);
    }

    @Override
    public void command() {
        creatorUser.createUser();
    }
}
