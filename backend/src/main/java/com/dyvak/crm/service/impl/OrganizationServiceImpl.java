package com.dyvak.crm.service.impl;

import com.dyvak.crm.domain.Organization;
import com.dyvak.crm.repository.OrganizationRepository;
import com.dyvak.crm.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Transactional(readOnly = true)
    public List<Organization> findAllOrganizationsByUserId(Integer userId) {
        return organizationRepository.findAllByUserId(userId);
    }
}
