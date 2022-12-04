package com.costetics.backend.classes;

import javax.persistence.*;

@Entity(name = "RolePerms")
@Table(name = "role_perms")
public class RolePerms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "role_id",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long roleId;

    @Column(
            name = "permission_id",
            updatable = false,
            columnDefinition = "BIGINT"
    )
    private Long permissionId;

    public RolePerms() {
    }

    public RolePerms(Long id, Long roleId, Long permissionId) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public RolePerms(Long roleId, Long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePerms{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}