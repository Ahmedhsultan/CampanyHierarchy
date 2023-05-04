package com.iti.companyhierarchy.hierarchy;

import com.iti.companyhierarchy.hierarchy.hierarchyComponents.ManagerComponent;

public enum Hierarchy {
    HIERARCHY;
    public ManagerComponent managerComponent;
    public ManagerComponent getManager(){
        return managerComponent;
    }
    public void setManager(ManagerComponent managerComponent){
        this.managerComponent = managerComponent;
    }
}
