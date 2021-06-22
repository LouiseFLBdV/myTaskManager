package com.stefanini.taskmanager.dao;

import com.stefanini.taskmanager.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao<T> implements Dao<T>{
    private final Session session;

    public abstract Class<T> getEntityClass();

    public AbstractDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    //todo re
    @Override
    public List<T> getAll() {
        return getByCriteria(null, null);
    }

    @Override
    public T get(long id) {
        checkTransaction();
        try{
            T entity = session.get(getEntityClass(), id);
            session.getTransaction().commit();
            return entity;
        } catch (Exception e){
//            logger.error("get entity by id  - error");
            return null;
        }
    }


    public List<T> getByCriteria(String criteriaField, String criteriaValue){
        checkTransaction();
        try{
            //todo
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
            Root<T> root = criteriaQuery.from(getEntityClass());
            criteriaQuery.select(root);
            if (criteriaField!=null){
                criteriaQuery.where(criteriaBuilder.equal(root.get(criteriaField), criteriaValue));
            }
            List<T> resultList = session.createQuery(criteriaQuery).getResultList();

            return resultList;
        } catch (Exception e){
//            logger.error("get entity by Criteria  - error");
        }
        return null;
    }

    @Override
    public T create(T entity) {
        checkTransaction();
        try{
            session.save(entity);
            session.getTransaction().commit();
            return entity;
        } catch (Exception e){
//            logger.error("entity save - error");
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public void update(T entity) {
        checkTransaction();
        try{
            session.merge(entity);
            session.getTransaction().commit();
        } catch (Exception e){
//            logger.error("entity update - error");
            session.getTransaction().rollback();
        }
    }

    @Override
    public void delete(T entity) {
        checkTransaction();
        try{
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e){
//            logger.error("entity delete - error");
            session.getTransaction().rollback();
        }
    }

    public void checkTransaction() {
        if (!session.getTransaction().isActive()) {
            session.getTransaction().begin();
//            logger.info("session begin - done");
        }
    }
}
