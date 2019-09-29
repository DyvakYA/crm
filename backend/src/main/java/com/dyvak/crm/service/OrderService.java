package com.dyvak.crm.service;

import com.dyvak.crm.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrdersByOrganizationId(Integer organizationId);
}
