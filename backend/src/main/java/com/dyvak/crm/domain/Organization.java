package com.dyvak.springbootvuejs.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String city;
    private String address;
    private String code;
    private String name;

    private Integer userId;
}
