package com.example.dvaraproject.ecom.user;

import com.example.dvaraproject.ecom.role.Role;

import java.util.Set;

public record UserRecord(Long id, String firstName, String lastName, String email, Set<Role> roles){}