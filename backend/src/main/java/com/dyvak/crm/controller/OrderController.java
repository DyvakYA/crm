package com.dyvak.crm.controller;

import com.dyvak.crm.aspects.Benchmark;
import com.dyvak.crm.aspects.LoggedArgs;
import com.dyvak.crm.aspects.LoggedReturn;
import com.dyvak.crm.domain.Order;
import com.dyvak.crm.service.OrderService;
import com.dyvak.crm.service.impl.OrderServiceImpl;
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
public class OrderController {

    private OrderService orderService;

    @LoggedArgs
    @LoggedReturn
    @Benchmark
    @RequestMapping(path = "/orders/organization/{organizationId}", method = RequestMethod.GET)
    public List<Order> orders(@PathVariable(value = "organizationId") Integer organizationId) {
        return orderService.findAllOrdersByOrganizationId(organizationId);
    }


}
