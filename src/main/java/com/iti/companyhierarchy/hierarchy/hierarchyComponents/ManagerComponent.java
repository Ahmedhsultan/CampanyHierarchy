package com.iti.companyhierarchy.hierarchy.hierarchyComponents;

import com.iti.companyhierarchy.persistence.entity.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ManagerComponent extends Employee{
    private Manager manager;

    private List<Employee> employees = new ArrayList<>();
    @Override
    public void save() {

    }
    public void addChild(Employee employee){
        employees.add(employee);
    }

    public void removeChild(Employee employee){
        employees.remove(employee);
    }
    public List<Employee> getChildren(){
        return employees;
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

    public com.iti.companyhierarchy.persistence.entity.Manager getManager() {
        return manager;
    }

    public void setManager(com.iti.companyhierarchy.persistence.entity.Manager manager) {
        this.manager = manager;
    }
}
