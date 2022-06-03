package com.brandis.brandisweb.service;

import com.brandis.brandisweb.model.bproduct.BProduct;

import java.util.Date;

public interface IProductBaseService<T> {
    T create(Long amount, Date dateOfPurchase, BProduct product);
}
