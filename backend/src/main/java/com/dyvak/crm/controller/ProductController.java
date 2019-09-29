package com.dyvak.crm.controller;

import com.dyvak.crm.aspects.Benchmark;
import com.dyvak.crm.aspects.LoggedArgs;
import com.dyvak.crm.aspects.LoggedReturn;
import com.dyvak.crm.domain.Product;
import com.dyvak.crm.service.ProductService;
import com.dyvak.crm.service.impl.ProductServiceImpl;
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
public class ProductController {

    private ProductService productService;

    @LoggedArgs
    @LoggedReturn
    @Benchmark
    @RequestMapping(path = "/products/{organizationId}", method = RequestMethod.GET)
    public List<Product> organizations(@PathVariable(value = "organizationId") Integer organizationId) {
        return productService.findAllProductsByOrganizationId(organizationId);
    }

}
