package com.brandis.brandisweb.repository;

import com.brandis.brandisweb.model.BUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BUserRepository extends JpaRepository<BUser, Long> {
    @Query("select user from BUser user where user.email = :email")
    Optional<BUser> findBUserByEmail(@Param("email") String username);
}
