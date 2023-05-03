package com.iti.companyhierarchy.hierarchy;

import java.util.Set;

public abstract class Employee {
    protected abstract void save();
    protected abstract Set<Employee> getOnline();
    protected abstract Set<Employee> getAll();
    protected abstract Set<Object> getTasks();
}
