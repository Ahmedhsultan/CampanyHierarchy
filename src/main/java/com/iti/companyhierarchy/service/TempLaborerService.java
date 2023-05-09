package com.iti.companyhierarchy.service;

import com.iti.companyhierarchy.DTO.TempLaborerDTO;
import com.iti.companyhierarchy.persistence.entity.TempLaborer;
import com.iti.companyhierarchy.persistence.repository.TempLaborerRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TempLaborerService extends BaseService<TempLaborer, TempLaborerRepo, TempLaborerDTO>{
    public TempLaborerService(ApplicationContext context) {
        super(context);
    }
}
