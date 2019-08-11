package com.dyvak.springbootvuejs.controller;

import com.dyvak.springbootvuejs.domain.User;
import com.dyvak.springbootvuejs.exception.UserNotFoundException;
import com.dyvak.springbootvuejs.exception.WrongPasswordException;
import com.dyvak.springbootvuejs.security.JWTGenerator;
import com.dyvak.springbootvuejs.security.JWTUser;
import com.dyvak.springbootvuejs.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class JWTController {

    private static final Logger log = LoggerFactory.getLogger(JWTController.class);

    private JWTGenerator jwtGenerator;
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String generate(@RequestBody User incomingUser) {
        log.info(incomingUser.toString());
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
