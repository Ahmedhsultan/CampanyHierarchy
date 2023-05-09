package com.iti.companyhierarchy.hierarchy.hierarchyComponents;

import com.iti.companyhierarchy.persistence.entity.TempLaborer;
import com.iti.companyhierarchy.service.TempLaborerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Scope("prototype")
public class TempLaborerComponent extends Employee {
    @Autowired
    private TempLaborerService tempLaborerService;
    public TempLaborer tempLaborer;

    @Override
    public void saveToDataBase() {
        tempLaborerService.save(tempLaborer);
    }

    @Override
    public Set<Employee> getOnline() {
        return null;
    }

    @Override
    public Set<Object> getTasks() {
        return null;
    }

    public TempLaborer getTempLaborer() {
        return tempLaborer;
    }

    public void setTempLaborer(TempLaborer tempLaborer) {
        this.tempLaborer = tempLaborer;
    }
}
