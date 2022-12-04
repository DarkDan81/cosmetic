package com.costetics.backend.repository;

import com.costetics.backend.classes.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findRoleById(Long id);

    Optional<Role> findRoleByName(String name);
}