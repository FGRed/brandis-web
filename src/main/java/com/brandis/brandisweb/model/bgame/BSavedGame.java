package com.brandis.brandisweb.model.bgame;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Saved_BGame")
@Entity
@Getter
@Setter
public class BSavedGame extends AbstractBGame {
    @Column(scale = 2)
    private Double userFunds;
    @Column(scale = 2)
    private Double companyFunds;

}
