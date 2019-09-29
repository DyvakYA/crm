package com.dyvak.crm.repository;


import com.dyvak.crm.domain.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    List<Organization> findAllByUserId(@Param("userId") Integer userId);
}
