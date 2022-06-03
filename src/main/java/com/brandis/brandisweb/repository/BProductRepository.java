package com.brandis.brandisweb.repository;

import com.brandis.brandisweb.model.bproduct.BProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BProductRepository extends JpaRepository<BProduct, Long> {
}
