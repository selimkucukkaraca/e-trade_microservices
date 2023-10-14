package com.selim.userservice.repository;

import com.selim.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByMail(String mail);
    boolean existsByMail(String mail);
}