package com.cyngofokglobalSalesManagementSystem.service.impl;

import com.cyngofokglobalSalesManagementSystem.entity.User;
import com.cyngofokglobalSalesManagementSystem.repository.UserRepository;
import com.cyngofokglobalSalesManagementSystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

   public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean userExistByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
