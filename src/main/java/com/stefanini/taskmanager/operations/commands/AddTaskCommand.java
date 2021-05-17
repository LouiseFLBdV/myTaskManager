package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.operations.creator.CreatorTask;
import com.stefanini.taskmanager.operations.creator.SimpleCreatorTask;

public class AddTaskCommand implements Command{

    CreatorTask creatorTask;

    public AddTaskCommand(String[] parameters) {
        creatorTask = new SimpleCreatorTask(parameters);
    }

    @Override
    public void command() {
        creatorTask.createTask();
    }
}
