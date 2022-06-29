package com.brandis.brandisweb.repository;

import com.brandis.brandisweb.model.bemployee.BEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BEmployeeRepository extends JpaRepository<BEmployee, Long> {
}