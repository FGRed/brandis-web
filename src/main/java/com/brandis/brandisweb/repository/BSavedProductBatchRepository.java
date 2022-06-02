package com.brandis.brandisweb.repository;

import com.brandis.brandisweb.model.BSavedProductBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BSavedProductBatchRepository extends JpaRepository<BSavedProductBatch, Long> {
}
