package com.example.project.dvaraecommerce.security;

import com.example.project.dvaraecommerce.user.UserRepository;
import com.example.project.dvaraecommerce.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;



@Component
public class ProductUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(ProductUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }
}