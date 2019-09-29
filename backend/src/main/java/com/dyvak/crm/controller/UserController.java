package com.dyvak.crm.controller;

import com.dyvak.crm.aspects.Benchmark;
import com.dyvak.crm.aspects.LoggedArgs;
import com.dyvak.crm.aspects.LoggedReturn;
import com.dyvak.crm.domain.User;
import com.dyvak.crm.security.UserRole;
import com.dyvak.crm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @LoggedArgs
    @LoggedReturn
    @Benchmark
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
        return user.getId();
    }

    @LoggedArgs
    @LoggedReturn
    @Benchmark
    @GetMapping(path = "/user/{id}")
    public @ResponseBody
    User getUserById(@PathVariable("id") long id) {
        return userService.findById(id);
    }

}
