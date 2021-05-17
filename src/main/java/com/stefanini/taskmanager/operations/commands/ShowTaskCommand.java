package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.operations.displayer.ConcreteDisplay;
import com.stefanini.taskmanager.operations.displayer.Displayer;

public class ShowTaskCommand implements Command{
    Displayer displayer;
    String[] parameters;
    public ShowTaskCommand(String[] parameters){
        this.parameters = parameters;
    }

    @Override
    public void command() {
        displayer = new ConcreteDisplay(parameters[1].substring(4));
        displayer.display();
    }
}
