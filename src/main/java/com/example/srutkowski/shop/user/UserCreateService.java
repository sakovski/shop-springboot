package com.example.srutkowski.shop.user;

import com.example.srutkowski.shop.user.domain.User;
import com.example.srutkowski.shop.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreateService {

    private final UserRepository userRepository;

    public UserCreateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createNew(User user) {
        userRepository.save(user);
    }
}
