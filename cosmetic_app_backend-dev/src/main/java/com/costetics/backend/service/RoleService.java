package com.costetics.backend.service;

import com.costetics.backend.classes.Role;
import com.costetics.backend.classes.RolePerms;
import com.costetics.backend.repository.PermissionRepository;
import com.costetics.backend.repository.RolePermsRepository;
import com.costetics.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePermsRepository rolePermsRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRole(Long id) {
        if (id == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        Optional<Role> role = roleRepository.findRoleById(id);
        if (role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found");
        return role;
    }

    @Transactional
    public void createRole(String roleName) {
        var roleOptional = roleRepository.findRoleByName(roleName);
        if (roleOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role already exist");
        roleRepository.save(new Role(roleName));
    }

    @Transactional
    public void updateRole(Role providedRole) {
        var role = roleRepository.findRoleById(providedRole.getId()).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Role with id " + providedRole.getId() + " does not exist"
        ));
        if (roleRepository.findRoleByName(providedRole.getName()).isPresent())
            throw new IllegalStateException("This role_name already taken");
        role.setName(providedRole.getName());
    }

    public void deleteRole(Long id) {
        if (!roleRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role with id " + id + " does not exist");
        roleRepository.deleteById(id);
    }

    public List<RolePerms> getRolePermissions(Long id) {
        if (!roleRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role with id " + id + " does not exist");
        return rolePermsRepository.findAllByRoleId(id);
    }
}