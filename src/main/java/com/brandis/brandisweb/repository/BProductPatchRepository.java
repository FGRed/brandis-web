package com.brandis.brandisweb.repository;

import com.brandis.brandisweb.model.bproductbatch.BProductBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BProductPatchRepository extends JpaRepository<BProductBatch, Long> {
}
