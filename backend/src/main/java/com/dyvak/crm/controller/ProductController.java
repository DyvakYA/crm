package com.dyvak.springbootvuejs.controller;

import com.dyvak.springbootvuejs.domain.Product;
import com.dyvak.springbootvuejs.service.ProductService;
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
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @RequestMapping(path = "/products/{organizationId}", method = RequestMethod.GET)
    public List<Product> organizations(@PathVariable(value = "organizationId") Integer organizationId) {
        log.info("GET products for organization");
        return productService.findAllProductsByOrganizationId(organizationId);
    }

}
