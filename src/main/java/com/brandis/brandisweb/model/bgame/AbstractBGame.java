package com.brandis.brandisweb.model.bgame;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class AbstractBGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(scale = 2)
    private double balance;
    @Column(length = 20)
    private String companyName;
    private Double brand;

}
