package com.stefanini.taskmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao<T> implements Dao<T>{

    public abstract Class<T> getEntityClass();
    private SessionFactory sessionFactory;
    private Session session;

    public AbstractDao() {
    }
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T getById(long id) {
        session = sessionFactory.getCurrentSession();
        try{
            return session.get(getEntityClass(), id);
        } catch (Exception e){
            System.out.println("exception:" + e);
            return null;
        }
    }

    @Override
    public List<T> getAll() {
        return getByCriteria(null, null);
    }

    @Override
    public T create(T entity) {
        session = sessionFactory.getCurrentSession();
        try{
            session.save(entity);
            return entity;
        } catch (Exception e){
            //
            return null;
        }
    }

    @Override
    public void update(T entity) {
        session = sessionFactory.getCurrentSession();
        try{
            session.merge(entity);
        } catch (Exception e){
            //
        }
    }

    @Override
    public void delete(T entity) {
        session = sessionFactory.getCurrentSession();
        try{
            session.delete(entity);
        } catch (Exception e){
            //
        }
    }

    public List<T> getByCriteria(String criteriaField, String criteriaValue){
        session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
        Root<T> root = criteriaQuery.from(getEntityClass());
        criteriaQuery.select(root);
        if (criteriaField!=null){
            criteriaQuery.where(criteriaBuilder.equal(root.get(criteriaField), criteriaValue));
        }
        return session.createQuery(criteriaQuery).getResultList();
    }
}
