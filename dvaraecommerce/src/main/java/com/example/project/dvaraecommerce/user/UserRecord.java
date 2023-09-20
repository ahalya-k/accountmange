package com.example.project.dvaraecommerce.user;

import com.example.project.dvaraecommerce.role.Role;

import java.util.Set;

public record UserRecord(Long id, String firstName, String lastName, String email, Set<Role> roles){}