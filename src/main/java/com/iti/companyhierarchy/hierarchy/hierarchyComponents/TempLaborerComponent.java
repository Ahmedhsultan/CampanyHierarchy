package com.iti.companyhierarchy.hierarchy.hierarchyComponents;

import com.iti.companyhierarchy.persistence.entity.TempLaborer;

import java.util.Set;

public class TempLaborerComponent extends Employee{
    public TempLaborer tempLaborer;

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

    public TempLaborer getTempLaborer() {
        return tempLaborer;
    }

    public void setTempLaborer(TempLaborer tempLaborer) {
        this.tempLaborer = tempLaborer;
    }
}
