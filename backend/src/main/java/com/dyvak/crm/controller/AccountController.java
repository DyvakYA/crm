package com.dyvak.springbootvuejs.controller;

import com.dyvak.springbootvuejs.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    private AccountService accountService;


}
