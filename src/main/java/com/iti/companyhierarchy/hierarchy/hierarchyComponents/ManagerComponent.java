package com.iti.companyhierarchy.hierarchy.hierarchyComponents;

import com.iti.companyhierarchy.persistence.entity.Manager;
import com.iti.companyhierarchy.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@Scope("prototype")
public class ManagerComponent extends Employee {
    @Autowired
    private ManagerService managerService;
    private Manager manager;
    private List<Employee> employees = new ArrayList<>();

    @Override
    public void saveToDataBase() {
        managerService.save(manager);
        employees.forEach(x -> x.saveToDataBase());
    }

    public void addChild(Employee employee) {
        employees.add(employee);
    }

    public void removeChild(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getChildren() {
        return employees;
    }

    @Override
    public Set<Employee> getOnline() {
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
