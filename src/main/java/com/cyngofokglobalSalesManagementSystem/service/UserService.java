package com.cyngofokglobalSalesManagementSystem.service;

import com.cyngofokglobalSalesManagementSystem.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserByEmail(String email);

    User saveUser(User user);

    boolean userExistByEmail(String email);
}
