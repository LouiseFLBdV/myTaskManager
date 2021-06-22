package com.stefanini.taskmanager.anotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Email {
    String message();
}
