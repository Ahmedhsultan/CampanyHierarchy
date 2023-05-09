package com.iti.companyhierarchy.service;

import com.iti.companyhierarchy.DTO.ManagerDTO;
import com.iti.companyhierarchy.persistence.entity.Manager;
import com.iti.companyhierarchy.persistence.repository.ManagerRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ManagerService extends BaseService<Manager, ManagerRepo, ManagerDTO>{
    public ManagerService(ApplicationContext context) {
        super(context);
    }
}
