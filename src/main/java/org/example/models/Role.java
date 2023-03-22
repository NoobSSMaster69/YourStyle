package org.example.models;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.security.core.userdetails.User;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;
@Entity
@Table(name = "role")
public class UserRole implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(value = "roleName")
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public UserRole() {
    }

    public UserRole(Long roleId) {
        this.roleId = roleId;
    }

    public UserRole(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }

}
