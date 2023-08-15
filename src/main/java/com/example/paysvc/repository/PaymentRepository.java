package com.example.paysvc.repository;

import com.example.paysvc.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    PaymentEntity findPaymentById(Long id);

    PaymentEntity findByIdempotency(String idempotency);


}
