package com.dyvak.crm.service.impl;

import com.dyvak.crm.domain.User;
import com.dyvak.crm.exception.UserNotFoundException;
import com.dyvak.crm.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
    }

    public User findById(long id) {
        return Optional.ofNullable(userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"))).get();
    }
}

