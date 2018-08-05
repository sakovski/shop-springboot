package com.example.srutkowski.shop.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {

    private final UserCreateService userCreateService;
    private final UserRoleRepository userRoleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRegisterService(UserCreateService userCreateService, UserRoleRepository userRoleRepository) {
        this.userCreateService = userCreateService;
        this.userRoleRepository = userRoleRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder(11);
    }

    public void registerNewUser(RegisterForm registerForm) {
        //TODO : MAPPER, MAIL SENDING
        UserRole userRole = userRoleRepository.findByName(RoleType.CUSTOMER)
                .orElseThrow(RuntimeException::new);
        User userCandidate = new User(registerForm.getEmail(), registerForm.getPassword(), userRole, registerForm.getFirstName(), registerForm.getLastName(), false);
        userCreateService.createNew(userCandidate);
    }
}
