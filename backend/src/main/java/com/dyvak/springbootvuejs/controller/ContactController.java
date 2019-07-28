package com.dyvak.springbootvuejs.controller;

import com.dyvak.springbootvuejs.repository.UserRepository;
import com.dyvak.springbootvuejs.domain.User;
import com.dyvak.springbootvuejs.security.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    private UserRepository userRepository;

    public UserController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(path = "/hello")
    public @ResponseBody
    String sayHello() {
        log.info("GET called on /hello resource");
        return HELLO_TEXT;
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    long addNewUser(@RequestParam String firstName, @RequestParam String lastName) {
        User user = new User(firstName, lastName, UserRole.USER);
        userRepository.save(user);

        log.info(user.toString() + " successfully saved into DB");

        return user.getId();
    }

    @GetMapping(path = "/user/{id}")
    public @ResponseBody
    User getUserById(@PathVariable("id") long id) {
        log.info("Reading user with id " + id + " from database.");
        Optional<User> user = userRepository.findById(id);

        return user.get();
    }

}
