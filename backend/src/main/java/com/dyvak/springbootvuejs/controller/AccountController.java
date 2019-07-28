package com.dyvak.springbootvuejs.controller;

import com.dyvak.springbootvuejs.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    private ContactService contactService;

    public ContactController(@Autowired ContactService contactService) {
        this.contactService = contactService;
    }


}
