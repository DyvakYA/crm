package com.dyvak.crm.service;

import com.dyvak.crm.domain.User;

import java.util.Optional;

public interface UserService {

    boolean existsByEmail(String email);

    Optional<User> findUserByEmail(String email);

    void createUser(User user);

    User findById(long id);
}
