package com.stefanini.taskmanager.dao.factory;

import com.stefanini.taskmanager.dao.Dao;
import com.stefanini.taskmanager.dao.impl.TaskDaoImpl;
import com.stefanini.taskmanager.dao.impl.UserDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    public static synchronized DaoFactory getDaoFactory(){
        if (daoFactory== null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public Dao getDao(String daoType){
        if (daoType.equals("User")){
            return UserDaoImpl.getUserDaoImpl();
        }else if (daoType.equals("Task")){
            return TaskDaoImpl.getTaskDaoImpl();
        }
        return null;
    }
}
