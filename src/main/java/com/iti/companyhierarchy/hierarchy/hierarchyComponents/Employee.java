package com.iti.companyhierarchy.hierarchy.hierarchyComponents;

import java.util.Set;

public abstract class Employee {
    public abstract void save();
    public abstract Set<Employee> getOnline();
    public abstract Set<Employee> getAll();
    public abstract Set<Object> getTasks();
}
