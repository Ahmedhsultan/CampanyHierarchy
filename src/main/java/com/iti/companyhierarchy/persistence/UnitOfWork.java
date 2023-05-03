package com.iti.companyhierarchy.persistence;

import com.iti.companyhierarchy.persistence.repository.AdministrativeRepo;
import com.iti.companyhierarchy.persistence.repository.EngineerRepo;
import com.iti.companyhierarchy.persistence.repository.MangerRepo;
import com.iti.companyhierarchy.persistence.repository.TempLaborerRepo;
import lombok.Data;

@Data
public class UnitOfWork {
    private AdministrativeRepo administrativeRepo;
    private EngineerRepo engineerRepo;
    private MangerRepo mangerRepo;
    private TempLaborerRepo tempLaborerRepo;

    public UnitOfWork(AdministrativeRepo administrativeRepo, EngineerRepo engineerRepo, MangerRepo mangerRepo, TempLaborerRepo tempLaborerRepo) {
        this.administrativeRepo = administrativeRepo;
        this.engineerRepo = engineerRepo;
        this.mangerRepo = mangerRepo;
        this.tempLaborerRepo = tempLaborerRepo;
    }
}