package com.iti.companyhierarchy.hierarchy.hierarchyComponents;

import java.util.Set;

public abstract class Employee {
    public abstract void saveToDataBase();
    public abstract Set<Employee> getOnline();
    public abstract Set<Object> getTasks();
}
