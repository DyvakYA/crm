package com.dyvak.crm.controller;

import com.dyvak.crm.service.OpportunityService;
import com.dyvak.crm.service.impl.OpportunityServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
@AllArgsConstructor
public class OpportunityController {

    private OpportunityService opportunityService;

}
