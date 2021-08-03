package com.stefanini.taskmanager.exception_handling;

public class ControllerException extends RuntimeException{

    public ControllerException(String message) {
        super(message);
    }
}
