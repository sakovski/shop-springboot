package com.example.srutkowski.shop.user;

import org.springframework.security.core.GrantedAuthority;

public enum RoleType implements GrantedAuthority {
    ADMIN,
    CUSTOMER;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
