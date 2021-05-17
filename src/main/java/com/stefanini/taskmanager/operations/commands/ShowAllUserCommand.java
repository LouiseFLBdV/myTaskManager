package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.operations.displayer.Displayer;
import com.stefanini.taskmanager.operations.displayer.SimpleDisplay;

public class ShowAllUserCommand implements Command{
    private final Displayer displayer;

    public ShowAllUserCommand(){
        displayer = new SimpleDisplay();
    }
    @Override
    public void command() {
        displayer.display();
    }
}
