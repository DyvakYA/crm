package com.dyvak.crm.controller;

import com.dyvak.crm.service.LeadService;
import com.dyvak.crm.service.impl.LeadServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
@AllArgsConstructor
public class LeadController {

    private LeadService leadService;

}
