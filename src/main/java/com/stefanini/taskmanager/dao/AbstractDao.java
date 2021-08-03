package com.stefanini.taskmanager.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao<T> implements Dao<T>{

    public abstract Class<T> getEntityClass();

    @Autowired
    private EntityManager entityManager;

    public AbstractDao() {
    }

    @Override
    public T getById(long id) {
        try{
            return entityManager.find(getEntityClass(), id);
        } catch (Exception e){
            //
            return null;
        }
    }

    @Override
    public List<T> getAll() {
        return getByCriteria(null, null);
    }

    @Override
    public T create(T entity) {
        try{
            entityManager.persist(entity);
            return entity;
        } catch (Exception e){
            //
            return null;
        }
    }

    @Override
    public void update(T entity) {
        try{
            entityManager.merge(entity);
        } catch (Exception e){
            //
        }
    }

    @Override
    public void delete(T entity) {
        try{
            entityManager.remove(entityManager.contains(entity) ?
                    entity: entityManager.merge(entity));
        } catch (Exception e){
            //
        }
    }

    public List<T> getByCriteria(String criteriaField, String criteriaValue){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
        Root<T> root = criteriaQuery.from(getEntityClass());
        criteriaQuery.select(root);
        if (criteriaField!=null){
            criteriaQuery.where(criteriaBuilder.equal(root.get(criteriaField), criteriaValue));
        }
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
