package com.brandis.brandisweb.repository;

import com.brandis.brandisweb.model.bgame.BSavedGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BSavedGameRepository extends JpaRepository<BSavedGame, Long> {
}
