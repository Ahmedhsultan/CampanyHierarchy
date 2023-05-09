package com.iti.companyhierarchy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.iti.companyhierarchy.hierarchy.hierarchyComponents.Employee;
import com.iti.companyhierarchy.service.HierarchyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HierarchyController {
    private final HierarchyService hierarchyService;

    public HierarchyController(HierarchyService hierarchyService) {
        this.hierarchyService = hierarchyService;
    }

    @PostMapping("/hierarchy")
    public ResponseEntity<String> postHierarchy(@RequestBody JsonNode jsonNode) throws JsonProcessingException {

        hierarchyService.convertToCompositePattern(jsonNode);

        return ResponseEntity.ok().body("ok");
    }
    @GetMapping("/getHierarchy")
    public ResponseEntity<List<Employee>> getHierarchy(){

        List<Employee> employees = hierarchyService.getHierarchy();

        return ResponseEntity.ok().body(employees);
    }
}
