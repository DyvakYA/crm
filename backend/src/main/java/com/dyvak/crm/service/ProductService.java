package com.dyvak.crm.service.impl;

import com.dyvak.crm.domain.Product;
import com.dyvak.crm.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl {

    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> findAllProductsByOrganizationId(Integer organizationId) {
        return productRepository.findAllByOrganizationId(organizationId);
    }
}
