package com.iti.companyhierarchy.persistence.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


public class BaseRepo <Entity, ID> {
    @PersistenceContext
    protected EntityManager entityManager;
    protected Class<Entity> entityClass;
    public BaseRepo(){
        //Get class type of generics by reflections
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] typeArguments = genericSuperclass.getActualTypeArguments();
        this.entityClass = (Class<Entity>) typeArguments[0];
    }

    @Transactional
    public Entity find(ID id){
        //Definitions
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<Entity> root = criteriaQuery.from(entityClass);

        //Queries
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id)).select(root);
        Entity result = null;
        try {
            result = entityManager.createQuery(criteriaQuery).getSingleResult();
        }catch (PersistenceException exception){
            throw new RuntimeException(entityClass.getSimpleName() + " Id isn't exist!!");
        }

        return result;
    }
    @Transactional
    public <Type> List<Entity> find(String columnName, Type value){
        //Definitions
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<Entity> root = criteriaQuery.from(entityClass);

        //Queries
        criteriaQuery.where(criteriaBuilder.equal(root.get(columnName), value)).select(root);
        List<Entity> result = entityManager.createQuery(criteriaQuery).getResultList();

        return result;
    }
    @Transactional
    public List<Entity> findAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<Entity> root = criteriaQuery.from(entityClass);

        //Queries
        criteriaQuery.select(root);
        List<Entity> result = entityManager.createQuery(criteriaQuery).getResultList();

        return result;
    }
    @Transactional
    public boolean delete(Entity entity){
        Entity entityMerged = entityManager.merge(entity);
        entityManager.remove(entityMerged);
        return true;
    }
    @Transactional
    public boolean delete(String columnName, String value){
        //Definitions
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Entity> criteriaDelete = criteriaBuilder.createCriteriaDelete(entityClass);
        Root<Entity> root = criteriaDelete.from(entityClass);

        //Queries
        criteriaDelete.where(criteriaBuilder.equal(root.get(columnName), value));
        int row = entityManager.createQuery(criteriaDelete).executeUpdate();

        if (row>0)
            return true;
        else
            return false;
    }
    @Transactional
    public boolean save(Entity entity){
        entityManager.persist(entity);
        return true;
    }
    @Transactional
    public Entity update(Entity entity){
        Entity entityMerged = entityManager.merge(entity);
        return entityMerged;
    }
    @Transactional
    public Long count(){
        //Definitions
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);

        //Queries
        criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(entityClass)));
        Long rowCount = entityManager.createQuery(criteriaQuery).getSingleResult();

        return rowCount;
    }
}