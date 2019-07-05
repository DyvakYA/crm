package com.dyvak.springbootvuejs.repository;


import com.dyvak.springbootvuejs.domain.Organization;
import com.dyvak.springbootvuejs.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    List<Organization> findAllByUserId(@Param("userId") Integer userId);
}
