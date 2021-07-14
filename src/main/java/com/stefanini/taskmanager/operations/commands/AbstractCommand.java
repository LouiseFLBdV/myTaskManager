package com.stefanini.taskmanager.operations.commands;

import com.stefanini.taskmanager.entities.Task;
import com.stefanini.taskmanager.model.InputModel;

import com.stefanini.taskmanager.model.OutputModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractCommand{

    private static final Logger logger = LogManager.getLogger();
    private InputModel inputModel;

    AbstractCommand(){
    }
    public abstract OutputModel execute();

    public InputModel getInputModel() {
            return inputModel;
        }

    public void setInputModel(InputModel inputModel) {
            this.inputModel = inputModel;
        }

    /**
     * This method is used to get Logger
     */
    public static Logger getLogger() {
            return logger;
        }
}
