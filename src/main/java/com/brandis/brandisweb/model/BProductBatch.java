package com.brandis.brandisweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "BProductBatch")
public class BProductBatch extends AbstractBProductBatch { }
