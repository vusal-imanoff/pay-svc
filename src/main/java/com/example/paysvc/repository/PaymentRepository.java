package com.example.paysvc.repository;

import com.example.paysvc.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Payment findPaymentById(Long id);
}
