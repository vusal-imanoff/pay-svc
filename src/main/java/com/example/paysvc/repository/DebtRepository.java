package com.example.paysvc.repository;

import com.example.paysvc.dto.Response.DebtResponse;
import com.example.paysvc.entity.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtRepository extends JpaRepository<DebtEntity, Long> {

    DebtResponse findByAccountCode(int accountCode);
}
