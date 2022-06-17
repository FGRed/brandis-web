package com.brandis.brandisweb.model.bgame;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "BGame")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class BGame extends AbstractBGame{
    @Builder
    public BGame(Long id, String companyName, Double balance, Double brand){
        super(id, balance, companyName, brand);
    }



}