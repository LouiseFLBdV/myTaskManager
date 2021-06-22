package com.stefanini.taskmanager.dao.factory;

import com.stefanini.taskmanager.dao.Dao;
import com.stefanini.taskmanager.dao.impl.TaskDaoImpl;
import com.stefanini.taskmanager.dao.impl.UserDaoImpl;
import com.stefanini.taskmanager.entities.DaoEntities;

public class DaoFactory {
    private static DaoFactory INSTANCE;

    private DaoFactory() {}

    public static synchronized DaoFactory getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DaoFactory();
        }
        return INSTANCE;
    }

    public Dao getDao(DaoEntities daoType){
        switch (daoType){
            case USERDAO:
                return UserDaoImpl.getInstance();
            case TASKDAO:
                return TaskDaoImpl.getInstance();
            default:
                return null;
        }
    }
}
