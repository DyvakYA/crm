package com.dyvak.crm.service;

import com.dyvak.crm.domain.Organization;

import java.util.List;

public interface OrganizationService {

    List<Organization> findAllOrganizationsByUserId(Integer userId);
}
