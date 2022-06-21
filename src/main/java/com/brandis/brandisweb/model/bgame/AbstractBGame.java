package com.brandis.brandisweb.model.bgame;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
public class AbstractBGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public AbstractBGame(){

    }
}
