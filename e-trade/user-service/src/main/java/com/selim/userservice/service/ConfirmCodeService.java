package com.selim.userservice.service;

import com.selim.entity.user.ConfirmCode;
import com.selim.userservice.repository.ConfirmCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmCodeService {

    private final ConfirmCodeRepository confirmCodeRepository;

    @CacheEvict(value = "confirmCodes", key = "#confirmCode")
    public void delete(ConfirmCode confirmCode) {
        confirmCodeRepository.delete(confirmCode);
    }

    @CachePut(value = "confirmCodes", key = "#confirmCode")
    public void save(ConfirmCode confirmCode) {
        confirmCodeRepository.save(confirmCode);
    }

    public void deleteById(Long id){
        confirmCodeRepository.deleteById(id);
    }
}