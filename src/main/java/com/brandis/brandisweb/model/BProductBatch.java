package com.brandis.brandisweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "BProductBatch")
public class BProductBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private BProduct bProduct;

    @Column(scale = 2)
    private Double amount;

    private Date expirationDate;
    private Date dateBought;
}
