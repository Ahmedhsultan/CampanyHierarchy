package com.iti.companyhierarchy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HierarchyController {
    @GetMapping("/getHierarchy")
    public ResponseEntity<String> getHierarchy(){
        return ResponseEntity.ok().body("ok");
    }
}
