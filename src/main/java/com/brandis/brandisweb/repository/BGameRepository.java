package com.brandis.brandisweb.repository;

import com.brandis.brandisweb.model.bgame.BGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BGameRepository extends JpaRepository<BGame, Long> {
}