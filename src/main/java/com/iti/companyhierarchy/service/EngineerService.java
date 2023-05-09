package com.iti.companyhierarchy.service;

import com.iti.companyhierarchy.DTO.EngineerDTO;
import com.iti.companyhierarchy.persistence.entity.Engineer;
import com.iti.companyhierarchy.persistence.repository.EngineerRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class EngineerService extends BaseService<Engineer, EngineerRepo, EngineerDTO> {
    public EngineerService(ApplicationContext context) {
        super(context);
    }
}
