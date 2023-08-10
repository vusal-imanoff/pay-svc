package com.example.paysvc.repository;

import com.example.paysvc.entity.Debt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtRepository extends JpaRepository<Debt, Long> {

    Debt findByAccountCode(int accountCode);
}
