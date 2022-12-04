package com.costetics.backend.controller;

import com.costetics.backend.classes.Role;
import com.costetics.backend.classes.RolePerms;
import com.costetics.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/get/{id}")
    public Optional<Role> getRole(@PathVariable("id") Long id) {
        return roleService.getRole(id);
    }

    @PostMapping("/create/{name}")
    public void createRole(@PathVariable("name") String name) {
        roleService.createRole(name);
    }

    @PutMapping("/update")
    public void updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
    }

    @PostMapping("/delete/{id}")
    public void deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRole(id);
    }

    @GetMapping("/get/{id}/permissions")
    public List<RolePerms> getRolePermissions(@PathVariable("id") Long id) {
        return roleService.getRolePermissions(id);
    }
}