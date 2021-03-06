package com.brandis.brandisweb.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T save(T entity);
    T findById(long id);
    void delete(T entity);
    void deleteById(long id);
    long count();
}
