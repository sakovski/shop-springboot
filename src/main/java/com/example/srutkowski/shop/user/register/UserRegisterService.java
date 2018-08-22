package com.example.srutkowski.shop.user.register;

import com.example.srutkowski.shop.user.RoleType;
import com.example.srutkowski.shop.user.UserCreateService;
import com.example.srutkowski.shop.user.domain.User;
import com.example.srutkowski.shop.user.domain.UserRole;
import com.example.srutkowski.shop.user.domain.UserRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {

    private final UserCreateService userCreateService;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegisterService(UserCreateService userCreateService,
                               UserRoleRepository userRoleRepository,
                               PasswordEncoder passwordEncoder) {
        this.userCreateService = userCreateService;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerNewUser(RegisterForm registerForm) {
        //TODO : MAPPER, MAIL SENDING
        UserRole userRole = userRoleRepository.findByName(RoleType.CUSTOMER)
                .orElseThrow(RuntimeException::new);
        User userCandidate = new User(registerForm.getEmail(), passwordEncoder.encode(registerForm.getPassword()), userRole, registerForm.getFirstName(), registerForm.getLastName(), false);
        userCreateService.createNew(userCandidate);
    }
}