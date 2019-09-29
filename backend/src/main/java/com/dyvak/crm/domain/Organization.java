package com.dyvak.crm.domain;

import lombok.Data;

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
