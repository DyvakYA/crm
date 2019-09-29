package com.dyvak.crm.repository;


import com.dyvak.crm.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAllOrdersByOrganizationId(@Param("organizationId") Integer organizationId);
}
