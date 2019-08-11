package com.dyvak.springbootvuejs.controller;

import com.dyvak.springbootvuejs.domain.Organization;
import com.dyvak.springbootvuejs.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api")
@AllArgsConstructor
public class OrganizationController {

    private static final Logger log = LoggerFactory.getLogger(OrganizationController.class);

    private OrganizationService organizationService;

    @RequestMapping(path = "/organizations/{userId}", method = RequestMethod.GET)
    public List<Organization> organizations(@PathVariable(value = "userId") Integer userId) {
        List<Organization> organizations = organizationService.findAllOrganizationsByUserId(userId);
        log.info("GET called on /organization/* {} ", organizations);
        return organizations;
    }
}
