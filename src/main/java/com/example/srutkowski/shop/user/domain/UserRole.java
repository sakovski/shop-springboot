package com.example.srutkowski.shop.user.domain;

import com.example.srutkowski.shop.user.RoleType;
import com.example.srutkowski.shop.user.domain.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private RoleType name;

    @OneToMany(mappedBy = "userRole", fetch = FetchType.EAGER)
    private Set<User> users;

    @Column(name = "enabled")
    private boolean enabled;

    public UserRole(@NotNull RoleType name, boolean enabled) {
        this.name = name;
        this.enabled = enabled;
        users = new HashSet<>();
    }

    public UserRole() {
    }

    public RoleType getName() {
        return name;
    }

    public void setName(RoleType name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
