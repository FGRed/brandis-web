package com.brandis.brandisweb.model.bgame;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "BGame")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BGame extends AbstractBGame{
    @Builder
    public BGame(Long id){
        super(id);
    }

    @OneToMany(targetEntity = BSavedGame.class)
    private List<BSavedGame> saves = new ArrayList<>();

    @Column(length = 20)
    private String companyName;
    @Column(length = 20)
    private Double originalBalance;


}