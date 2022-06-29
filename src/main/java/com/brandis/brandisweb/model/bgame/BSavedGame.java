package com.brandis.brandisweb.model.bgame;

import com.brandis.brandisweb.model.bemployee.BEmployee;
import com.brandis.brandisweb.model.bemployee.BHiredEmployee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Saved_BGame")
@Entity
@Getter
@Setter
public class BSavedGame extends AbstractBGame {
    @Column(scale = 2)
    private Double userFunds;
    @Column(scale = 2)
    private Double companyFunds;
    @Column(scale = 2)
    private Double loanFunds;
    @Column(scale = 2)
    private Double brand;
    private Boolean currentSave;

    @ManyToMany(targetEntity = BHiredEmployee.class)
    private List<BHiredEmployee> hiredEmployees = new ArrayList<>();

    @ManyToMany(targetEntity = BEmployee.class)
    private List<BEmployee> availableEmployees = new ArrayList<>();

}
