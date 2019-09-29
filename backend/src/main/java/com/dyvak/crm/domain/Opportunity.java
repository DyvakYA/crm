package com.dyvak.crm.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "opportunities")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
}
