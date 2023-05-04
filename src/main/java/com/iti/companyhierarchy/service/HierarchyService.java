package com.iti.companyhierarchy.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.iti.companyhierarchy.hierarchy.Hierarchy;
import com.iti.companyhierarchy.hierarchy.hierarchyComponents.*;
import com.iti.companyhierarchy.persistence.entity.Administrative;
import com.iti.companyhierarchy.persistence.entity.Engineer;
import com.iti.companyhierarchy.persistence.entity.Manager;
import com.iti.companyhierarchy.persistence.entity.TempLaborer;
import java.util.Iterator;
import java.util.List;

public class HierarchyService {
    public void convertToCompositePattern(JsonNode jsonNode){
        String type = jsonNode.get("type").textValue();

        if (type.equals("manager")) {
            ManagerComponent rootManagerComponent = convertJsonToManagerComponent(jsonNode);
            Hierarchy.HIERARCHY.setManager(rootManagerComponent);

            Iterator<JsonNode> childrenJson = jsonNode.get("children").elements();
            while (childrenJson.hasNext()){
                JsonNode jsonNodeNext = childrenJson.next();
                type = jsonNodeNext.get("type").textValue();
                addChild(type, jsonNodeNext);
            }
        }
    }

    public List<Employee> getHierarchy(){
        return Hierarchy.HIERARCHY.getManager().getChildren();
    }

    private void addChild(String type, JsonNode jsonNode){
        switch (type.toLowerCase()){
            case "manager":
                ManagerComponent managerComponent = convertJsonToManagerComponent(jsonNode);
                {
                    Iterator<JsonNode> childrenJson = jsonNode.get("children").elements();
                    while (childrenJson.hasNext()){
                        JsonNode jsonNodeNext = childrenJson.next();
                        type = jsonNodeNext.get("type").textValue();
                        addChild(type, jsonNode);
                    }
                }
                break;
            case "engineer":
                EngineerComponent engineerComponent = convertJsonToEngineerComponent(jsonNode);
                {
                    Iterator<JsonNode> childrenJson = jsonNode.get("children").elements();
                    while (childrenJson.hasNext()){
                        JsonNode jsonNodeNext = childrenJson.next();
                        type = jsonNodeNext.get("type").textValue();
                        addChild(type, jsonNode);
                    }
                }
                break;
            case "administrative":
                AdministrativeComponent administrativeComponent = convertJsonToAdministrativeComponent(jsonNode);
                break;
            case "tempLaborer":
                TempLaborerComponent tempLaborerComponent = convertJsonToTempLaborerComponent(jsonNode);
                break;
        }
    }
    private ManagerComponent convertJsonToManagerComponent(JsonNode jsonNode){
        ManagerComponent managerComponent = new ManagerComponent();
        Manager manager = new Manager();
        manager.setFirstName(jsonNode.get("firstName").textValue());
        manager.setLastName(jsonNode.get("lastName").textValue());
        managerComponent.setManager(manager);

        return managerComponent;
    }
    private EngineerComponent convertJsonToEngineerComponent(JsonNode jsonNode){
        EngineerComponent engineerComponent = new EngineerComponent();
        Engineer engineer = new Engineer();
        engineer.setFirstName(jsonNode.get("firstName").textValue());
        engineer.setLastName(jsonNode.get("lastName").textValue());
        engineerComponent.setEngineer(engineer);

        return engineerComponent;
    }
    private AdministrativeComponent convertJsonToAdministrativeComponent(JsonNode jsonNode){
        AdministrativeComponent administrativeComponent = new AdministrativeComponent();
        Administrative administrative = new Administrative();
        administrative.setFirstName(jsonNode.get("firstName").textValue());
        administrative.setLastName(jsonNode.get("lastName").textValue());
        administrativeComponent.setAdministrative(administrative);

        return administrativeComponent;
    }
    private TempLaborerComponent convertJsonToTempLaborerComponent(JsonNode jsonNode){
        TempLaborerComponent laborerComponent = new TempLaborerComponent();
        TempLaborer tempLaborer = new TempLaborer();
        tempLaborer.setFirstName(jsonNode.get("firstName").textValue());
        tempLaborer.setLastName(jsonNode.get("lastName").textValue());
        laborerComponent.setTempLaborer(tempLaborer);

        return laborerComponent;
    }
}
