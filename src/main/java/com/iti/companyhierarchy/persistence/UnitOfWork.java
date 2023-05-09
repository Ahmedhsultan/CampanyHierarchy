package com.iti.companyhierarchy.persistence;

import com.iti.companyhierarchy.persistence.repository.AdministrativeRepo;
import com.iti.companyhierarchy.persistence.repository.EngineerRepo;
import com.iti.companyhierarchy.persistence.repository.ManagerRepo;
import com.iti.companyhierarchy.persistence.repository.TempLaborerRepo;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UnitOfWork {
    private AdministrativeRepo administrativeRepo;
    private EngineerRepo engineerRepo;
    private ManagerRepo managerRepo;
    private TempLaborerRepo tempLaborerRepo;

    public UnitOfWork(AdministrativeRepo administrativeRepo, EngineerRepo engineerRepo, ManagerRepo managerRepo, TempLaborerRepo tempLaborerRepo) {
        this.administrativeRepo = administrativeRepo;
        this.engineerRepo = engineerRepo;
        this.managerRepo = managerRepo;
        this.tempLaborerRepo = tempLaborerRepo;
    }
}