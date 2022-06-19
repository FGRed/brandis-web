package com.brandis.brandisweb.model.bgame;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(targetEntity = BSavedGame.class)
    private List<BSavedGame> saves = new ArrayList<>();


}