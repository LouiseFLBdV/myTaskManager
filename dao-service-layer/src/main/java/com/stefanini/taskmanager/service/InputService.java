package com.stefanini.taskmanager.service;

import com.stefanini.taskmanager.dto.InputArgs;

import java.util.Arrays;

public class InputService {
    public static InputArgs getInputArgs(String[] args){
        InputArgs inputArgs = new InputArgs();
        inputArgs.setCommandName(args[0].toLowerCase());
        for (String arg: Arrays.copyOfRange(args, 1, args.length)){
            if(arg.substring(0, 3).equals("ln=")){
                inputArgs.setLastName(arg.substring(4));
            }else if(arg.substring(0, 3).equals("un=")){
                inputArgs.setUserName(arg.substring(4));

            }else if(arg.substring(0,3).equals("tt=")){
                inputArgs.setTaskTittle(arg.substring(4));

            }else if (arg.substring(0,3).equals("td=")){
                inputArgs.setDesc(arg.substring(4));
            }else if (arg.substring(0,3).equals("fn=")){
                inputArgs.setFirstName(arg.substring(4));
            }
        }
        return inputArgs;
    }
}
