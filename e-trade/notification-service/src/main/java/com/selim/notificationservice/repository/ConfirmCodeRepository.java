package com.selim.notificationservice.repository;

import com.selim.notificationservice.model.ConfirmCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmCodeRepository extends JpaRepository<ConfirmCode, Long> {
}
