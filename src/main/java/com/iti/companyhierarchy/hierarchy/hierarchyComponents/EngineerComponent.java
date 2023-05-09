package com.iti.companyhierarchy.hierarchy.hierarchyComponents;

import com.iti.companyhierarchy.persistence.entity.Engineer;
import com.iti.companyhierarchy.service.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@Scope("prototype")
public class EngineerComponent extends Employee{
    @Autowired
    private EngineerService engineerService;
    private Engineer engineer;
    private List<Employee> employees = new ArrayList<>();
    @Override
    public void saveToDataBase() {
        engineerService.save(engineer);
        employees.forEach(x -> x.saveToDataBase());
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
