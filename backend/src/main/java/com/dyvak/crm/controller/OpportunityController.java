package com.dyvak.springbootvuejs.controller;

import com.dyvak.springbootvuejs.service.OpportunityService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
@AllArgsConstructor
public class OpportunityController {

    private static final Logger log = LoggerFactory.getLogger(OpportunityController.class);

    private OpportunityService opportunityService;

}
