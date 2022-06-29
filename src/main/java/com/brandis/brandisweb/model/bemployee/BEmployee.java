package com.brandis.brandisweb.model.bemployee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@Getter
@Setter
public class BEmployee {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
