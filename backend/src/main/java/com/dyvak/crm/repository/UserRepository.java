package com.dyvak.springbootvuejs.repository;


import com.dyvak.springbootvuejs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(@Param("email") String email);

    boolean existsByEmail(@Param("email") String email);
}
