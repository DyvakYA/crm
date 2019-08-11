package com.dyvak.springbootvuejs.controller;

import com.dyvak.springbootvuejs.service.LeadService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
@AllArgsConstructor
public class LeadController {

    private static final Logger log = LoggerFactory.getLogger(LeadController.class);

    private LeadService leadService;

}
