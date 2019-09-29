package com.dyvak.crm.service;

import com.dyvak.crm.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProductsByOrganizationId(Integer organizationId);
}
