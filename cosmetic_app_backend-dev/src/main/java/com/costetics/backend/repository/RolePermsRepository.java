package com.costetics.backend.repository;

import com.costetics.backend.classes.RolePerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermsRepository extends JpaRepository<RolePerms, Long> {

    List<RolePerms> findAllByRoleId(Long roleId);

    List<RolePerms> findAllByPermissionId(Long permissionId);
}