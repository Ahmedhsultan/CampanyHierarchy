package com.iti.companyhierarchy.hierarchy.hierarchyComponents;

import com.iti.companyhierarchy.persistence.entity.Engineer;
import com.iti.companyhierarchy.persistence.entity.Manager;

import java.util.Set;

public class EngineerComponent extends Employee{
    private Engineer engineer;

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

    public Engineer getEngineer() {
        return engineer;
    }

    public void setEngineer(Engineer engineer) {
        this.engineer = engineer;
    }
}
