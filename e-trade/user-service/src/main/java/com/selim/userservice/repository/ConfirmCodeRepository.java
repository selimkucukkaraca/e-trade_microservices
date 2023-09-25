package com.selim.userservice.repository;

import com.selim.userservice.model.ConfirmCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmCodeRepository extends JpaRepository<ConfirmCode, Long> {
}
