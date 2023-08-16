package com.example.paysvc.repository;

import com.example.paysvc.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    Optional<PaymentEntity> findPaymentById(Long id);

    Optional<PaymentEntity> findByKey(String key);


}
