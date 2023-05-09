package com.iti.companyhierarchy.service;

import com.iti.companyhierarchy.persistence.repository.BaseRepo;
import com.iti.companyhierarchy.util.Mapper;
import jakarta.persistence.PersistenceException;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseService<Entity, Repo extends BaseRepo<Entity, ?>, DTOReq> {
    private Repo repo;
    private Class<Entity> entityClass;
    private Class<Repo> repoClass;

    public BaseService(ApplicationContext context) {
        //Get class type of generics by reflections
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] typeArguments = genericSuperclass.getActualTypeArguments();
        this.entityClass = (Class<Entity>) typeArguments[0];
        this.repoClass = (Class<Repo>) typeArguments[1];
        //Get bean of repo from context
        this.repo = context.getBean(repoClass);
    }

    public Entity post(DTOReq dtoReq) throws PersistenceException {
        //Create object of entity
        Entity entity = Mapper.MAPPER.getModelMapper().map(dtoReq, entityClass);

        //Save this entity
        try {
            repo.save(entity);
        } catch (PersistenceException persistenceException) {
            throw new RuntimeException("Can't save this " + entity.getClass().getSimpleName() + " !!");
        }

        return entity;
    }

    public Entity save(Entity entity) throws PersistenceException {
        //Save this entity
        try {
            repo.save(entity);
        } catch (PersistenceException persistenceException) {
            throw new RuntimeException("Can't save this " + entity.getClass().getSimpleName() + " !!");
        }

        return entity;
    }
}
