package com.stefanini.taskmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.stefanini.taskmanager.dao.Dao;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao<T> implements Dao<T>{
    public abstract Class<T> getEntityClass();

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public AbstractDao() {

    }

    public List<T> getAll() {
        return getByCriteria(null, null);
    }

    public List<T> getByCriteria(String criteriaField, String criteriaValue){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
        Root<T> root = criteriaQuery.from(getEntityClass());
        criteriaQuery.select(root);
        if (criteriaField!=null){
            criteriaQuery.where(criteriaBuilder.equal(root.get(criteriaField), criteriaValue));
        }
        List<T> resultList = session.createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    public T create(T entity) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.save(entity);
            session.getTransaction().commit();
            return entity;
        } catch (Exception e){
//            logger.error("entity save - error");
            return null;
        }
    }

    public void update(T entity) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.merge(entity);
            session.getTransaction().commit();
        } catch (Exception e){
//            logger.error("entity update - error");
            session.getTransaction().rollback();
        }
    }

    public void delete(T entity) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e){
//            logger.error("entity delete - error");
        }
    }

}
