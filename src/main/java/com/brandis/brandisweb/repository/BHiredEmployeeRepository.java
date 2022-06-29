package com.brandis.brandisweb.repository;

import com.brandis.brandisweb.model.bemployee.BHiredEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BHiredEmployeeRepository extends JpaRepository<BHiredEmployee, Long>, JpaSpecificationExecutor<BHiredEmployee> {
}