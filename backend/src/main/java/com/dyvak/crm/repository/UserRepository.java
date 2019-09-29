package com.dyvak.crm.repository;


import com.dyvak.crm.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(@Param("notification") String email);

    boolean existsByEmail(@Param("notification") String email);
}
