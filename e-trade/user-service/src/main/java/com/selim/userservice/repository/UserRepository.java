package com.selim.userservice.repository;

import com.selim.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByMail(String mail);
    boolean existsUserByMail(String mail);

}