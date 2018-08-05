package com.example.srutkowski.shop.config;

import com.example.srutkowski.shop.user.User;
import com.example.srutkowski.shop.user.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UsersDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public UsersDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
        Collection<GrantedAuthority> authorities = Collections.singleton(user.getUserRole().getName());
        return new org.springframework.security.core.userdetails.User(email, user.getPassword(), authorities);
    }
}
