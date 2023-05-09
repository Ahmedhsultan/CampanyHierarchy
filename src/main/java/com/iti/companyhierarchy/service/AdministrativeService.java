package com.iti.companyhierarchy.service;

import com.iti.companyhierarchy.DTO.AdminstrativeDTO;
import com.iti.companyhierarchy.persistence.entity.Administrative;
import com.iti.companyhierarchy.persistence.repository.AdministrativeRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AdministrativeService extends BaseService<Administrative, AdministrativeRepo, AdminstrativeDTO> {
    public AdministrativeService(ApplicationContext context) {
        super(context);
    }
}
