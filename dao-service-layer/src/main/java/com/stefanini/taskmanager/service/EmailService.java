package com.stefanini.taskmanager.service;

import com.stefanini.taskmanager.anotation.Email;
import com.stefanini.taskmanager.anotation.EmailField;
import com.stefanini.taskmanager.entities.User;

import java.lang.reflect.Field;

public class EmailService {
    public static void sendEmail(Object entity){
        String message = entity.getClass().getAnnotation(Email.class).message();

        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field:fields) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(EmailField.class)){
                try {
                    message = message.replace(field.getName(), (CharSequence) field.get(entity));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                finally {
                    field.setAccessible(false);
                }
            }
        }

        System.out.println(message);

    }
}
