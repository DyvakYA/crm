package com.dyvak.crm.repository;


import com.dyvak.crm.domain.Account;
import com.dyvak.crm.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findAllByOrganizationId(@Param("organizationId") Integer orgId);

}
