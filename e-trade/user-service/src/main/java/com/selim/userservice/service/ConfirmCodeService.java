package com.selim.userservice.service;

import com.selim.entity.user.ConfirmCode;
import com.selim.userservice.repository.ConfirmCodeRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfirmCodeService {

    private final ConfirmCodeRepository confirmCodeRepository;

    public ConfirmCodeService(ConfirmCodeRepository confirmCodeRepository) {
        this.confirmCodeRepository = confirmCodeRepository;
    }

    public void delete(ConfirmCode confirmCode) {
        confirmCodeRepository.delete(confirmCode);
    }

    public void deleteById(Long id){
        confirmCodeRepository.deleteById(id);
    }

    public void save(ConfirmCode confirmCode) {
        confirmCodeRepository.save(confirmCode);
    }
}