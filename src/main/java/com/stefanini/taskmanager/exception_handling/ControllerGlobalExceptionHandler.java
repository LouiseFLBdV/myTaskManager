package com.stefanini.taskmanager.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<InputIncorrectData> handleException(ControllerException exception){
        InputIncorrectData incorrectData = new InputIncorrectData();
        incorrectData.setInfo(exception.getMessage());

        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<InputIncorrectData> handleException(Exception exception){
        InputIncorrectData incorrectData = new InputIncorrectData();
        incorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST );
    }
}
