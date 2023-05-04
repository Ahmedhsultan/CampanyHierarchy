package com.iti.companyhierarchy.hierarchy.hierarchyComponents;

import com.iti.companyhierarchy.persistence.entity.Administrative;
import com.iti.companyhierarchy.service.AdministrativeService;

import java.util.Set;

public class AdministrativeComponent extends Employee{
    public Administrative administrative;

    @Override
    public void save() {

    }
    @Override
    public Set<Employee> getOnline() {
        return null;
    }

    @Override
    public Set<Employee> getAll() {
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
