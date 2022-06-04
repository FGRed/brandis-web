package com.brandis.brandisweb.repository;

import com.brandis.brandisweb.model.bproducer.BProducer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BProducerRepository extends JpaRepository<BProducer, Long> {
}
