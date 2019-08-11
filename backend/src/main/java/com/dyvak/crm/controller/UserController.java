package com.dyvak.springbootvuejs.controller;

import com.dyvak.springbootvuejs.domain.User;
import com.dyvak.springbootvuejs.security.UserRole;
import com.dyvak.springbootvuejs.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    long addNewUser(@RequestParam String email, @RequestParam String password) {
        User user = User.builder()
                .email(email)
                .password(password)
                .role(UserRole.USER)
                .build();
        userService.createUser(user);
        log.info(user.toString() + " successfully saved into DB");
        return user.getId();
    }

    @GetMapping(path = "/user/{id}")
    public @ResponseBody
    User getUserById(@PathVariable("id") long id) {
        log.info("Reading user with id " + id + " from database.");
        return userService.findById(id);
    }

}
