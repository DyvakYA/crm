package com.dyvak.crm.repository;


import com.dyvak.crm.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAllByOrganizationId(@Param("organizationId") Integer organizationId);
}
