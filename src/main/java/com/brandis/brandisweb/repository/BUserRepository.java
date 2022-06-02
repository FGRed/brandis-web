package com.brandis.brandisweb.repository;

import com.brandis.brandisweb.model.BUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BUserRepository extends JpaRepository<BUser, Long> {
}
