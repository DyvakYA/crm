package com.dyvak.springbootvuejs.domain;

import lombok.Data;
import lombok.Singular;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String code;
    private String name;
    private BigDecimal price;

    private Integer organizationId;

    @Singular
    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();
}
