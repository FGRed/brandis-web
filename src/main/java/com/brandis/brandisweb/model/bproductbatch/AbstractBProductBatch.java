package com.brandis.brandisweb.model.bproductbatch;

import com.brandis.brandisweb.model.bproduct.BProduct;
import com.brandis.brandisweb.model.bgame.BGame;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class AbstractBProductBatch {
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private BProduct bProduct;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long amount;
    private Date expirationDate;
    private Date dateBought;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bgame_id", referencedColumnName = "id")
    private BGame bGame;
}
