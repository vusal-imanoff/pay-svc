package com.example.paysvc.repository;

import com.example.paysvc.model.response.DebtResponse;
import com.example.paysvc.entity.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DebtRepository extends JpaRepository<DebtEntity, Long> {

    Optional<DebtEntity> findByAccountCode(Long accountCode);
}
