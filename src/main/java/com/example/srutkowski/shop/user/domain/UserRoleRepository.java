package com.example.srutkowski.shop.user.domain;

import com.example.srutkowski.shop.user.RoleType;
import com.example.srutkowski.shop.user.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findByName(RoleType name);
}
