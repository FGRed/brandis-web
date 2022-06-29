package com.brandis.brandisweb.model.bemployee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class BHiredEmployee {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private BEmployee employee;

    private Double salary;

    public BHiredEmployee(BEmployee bEmployee, Double salary){
        this.salary = salary;
        setEmployee(bEmployee);
    }


}
