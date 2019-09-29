package com.dyvak.crm.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
}
