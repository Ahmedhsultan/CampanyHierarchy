package com.iti.companyhierarchy.hierarchy.hierarchyComponents;

import com.iti.companyhierarchy.persistence.entity.Administrative;
import com.iti.companyhierarchy.service.AdministrativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
@Scope("prototype")
public class AdministrativeComponent extends Employee{
    @Autowired
    private AdministrativeService administrativeService;
    public Administrative administrative;

    @Override
    public void saveToDataBase() {
        administrativeService.save(administrative);
    }

    @Override
    public Set<Employee> getOnline() {
        return null;
    }

    @Override
    public Set<Object> getTasks() {
        return null;
    }

    public Administrative getAdministrative() {
        return administrative;
    }

    public void setAdministrative(Administrative administrative) {
        this.administrative = administrative;
    }
}
