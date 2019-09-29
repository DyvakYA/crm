package com.dyvak.crm.controller;

import com.dyvak.crm.aspects.Benchmark;
import com.dyvak.crm.aspects.LoggedArgs;
import com.dyvak.crm.aspects.LoggedReturn;
import com.dyvak.crm.domain.User;
import com.dyvak.crm.exception.UserNotFoundException;
import com.dyvak.crm.exception.WrongPasswordException;
import com.dyvak.crm.security.JWTGenerator;
import com.dyvak.crm.security.JWTUser;
import com.dyvak.crm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class JWTController {

    private JWTGenerator jwtGenerator;
    private UserService userService;

    @LoggedArgs
    @LoggedReturn
    @Benchmark
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String generate(@RequestBody User incomingUser) {
        if (!userService.existsByEmail(incomingUser.getEmail())) {
            throw new UserNotFoundException("User not found");
        }

        Optional<User> optionalUser = userService.findUserByEmail(incomingUser.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (!incomingUser.getPassword().equals(user.getPassword())) {
                throw new WrongPasswordException();
            } else {
                SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);

                JWTUser jwtUser = JWTUser.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build();
                return jwtGenerator.generate(jwtUser);
            }
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
