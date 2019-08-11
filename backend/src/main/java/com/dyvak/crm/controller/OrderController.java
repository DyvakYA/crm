package com.dyvak.springbootvuejs.controller;

import com.dyvak.springbootvuejs.domain.Order;
import com.dyvak.springbootvuejs.service.OrderService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api")
@AllArgsConstructor
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private OrderService orderService;

    @RequestMapping(path = "/orders/{organizationId}", method = RequestMethod.GET)
    public List<Order> orders(@PathVariable(value = "organizationId") Integer organizationId) {
        log.info("GET called on /hello resource");
        return orderService.findAllOrdersByOrganizationId(organizationId);
    }


}
