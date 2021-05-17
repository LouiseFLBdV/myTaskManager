package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.operations.creator.CreatorTask;
import com.stefanini.taskmanager.operations.creator.GroupCreatorTask;

public class AddGroupTaskCommand implements Command{
    CreatorTask creatorTask;
    public AddGroupTaskCommand(String[] parameters) {
        creatorTask = new GroupCreatorTask(parameters);
    }

    @Override
    public void command() {
        creatorTask.createTask();
    }
}
