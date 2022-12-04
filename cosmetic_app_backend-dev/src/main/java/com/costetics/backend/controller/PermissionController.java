package com.costetics.backend.controller;

import com.costetics.backend.classes.Permission;
import com.costetics.backend.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/list")
    public List<Permission> getRoles() {
        return permissionService.getFullList();
    }
}