package com.brandis.brandisweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "BProduct")
@Getter
@Setter
public class BProduct {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100)
    private String name;
    private int daysTillExpiration;
    @Column(scale = 2)
    private Double price;
}