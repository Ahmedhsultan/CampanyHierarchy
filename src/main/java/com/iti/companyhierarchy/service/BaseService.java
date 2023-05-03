package com.iti.companyhierarchy.service;

import com.iti.companyhierarchy.persistence.repository.BaseRepo;
import com.iti.companyhierarchy.util.Mapper;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseService <Entity, DTOResp, Repo extends BaseRepo<Entity, ?>, DTOReq> {
    @Autowired
    private ApplicationContext context;
    private Repo repo;
    private Class<DTOResp> dtoClass;
    private Class<Entity> entityClass;
    private Class<Repo> RepoClass;

    public BaseService() {
        //Get class type of generics by reflections
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] typeArguments = genericSuperclass.getActualTypeArguments();
        this.entityClass = (Class<Entity>) typeArguments[0];
        this.dtoClass = (Class<DTOResp>) typeArguments[1];
        this.RepoClass = (Class<Repo>) typeArguments[2];
        //Get bean of repo from context
        this.repo = context.getBean(RepoClass);
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
}
