package com.dyvak.crm.controller;

import com.dyvak.crm.aspects.Benchmark;
import com.dyvak.crm.aspects.LoggedArgs;
import com.dyvak.crm.aspects.LoggedReturn;
import com.dyvak.crm.domain.Organization;
import com.dyvak.crm.service.OrganizationService;
import com.dyvak.crm.service.impl.OrganizationServiceImpl;
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

    private OrganizationService organizationService;

    @LoggedArgs
    @LoggedReturn
    @Benchmark
    @RequestMapping(path = "/organizations/{userId}", method = RequestMethod.GET)
    public List<Organization> organizations(@PathVariable(value = "userId") Integer userId) {
        List<Organization> organizations = organizationService.findAllOrganizationsByUserId(userId);
        return organizations;
    }
}
