package com.brandis.brandisweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class AbstractBProductBatch {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private BProduct bProduct;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long amount;
    private Date expirationDate;
    private Date dateBought;
}
