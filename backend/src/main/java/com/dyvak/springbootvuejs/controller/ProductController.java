package com.dyvak.springbootvuejs.controller;

import com.dyvak.springbootvuejs.repository.UserRepository;
import com.dyvak.springbootvuejs.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/hello")
    public @ResponseBody String sayHello() {
        LOG.info("GET called on /hello resource");
        return HELLO_TEXT;
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody long addNewUser (@RequestParam String firstName, @RequestParam String lastName) {
        User user = new User(firstName, lastName);
        userRepository.save(user);

        LOG.info(user.toString() + " successfully saved into DB");

        return user.getId();
    }

    @GetMapping(path="/user/{id}")
    public @ResponseBody User getUserById(@PathVariable("id") long id) {
        LOG.info("Reading user with id " + id + " from database.");
        return userRepository.findById(id).get();
    }

}