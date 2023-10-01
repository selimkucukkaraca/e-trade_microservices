package com.selim.userservice.repository;

import com.selim.entity.user.ConfirmCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmCodeRepository extends JpaRepository<ConfirmCode, Long> {
}
