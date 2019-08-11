package com.dyvak.crm.service.impl;

import com.dyvak.crm.domain.Order;
import com.dyvak.crm.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<Order> findAllOrdersByOrganizationId(Integer organizationId) {
        return orderRepository.findAllOrdersByOrganizationId(organizationId);
    }
}
