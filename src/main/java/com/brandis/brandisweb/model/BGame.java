package com.brandis.brandisweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "BGame")
public class BGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(scale = 2)
    private double Balance;
    @Column(length = 20)
    private String CompanyName;
    @Column(length = 20)
    private String Brand;
}