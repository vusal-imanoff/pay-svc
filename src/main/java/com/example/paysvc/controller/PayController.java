package com.example.paysvc.controller;

import com.example.paysvc.dto.Response.DebtResponse;
import com.example.paysvc.dto.Response.PaymentResponse;
import com.example.paysvc.entity.DebtEntity;
import com.example.paysvc.entity.PaymentEntity;
import com.example.paysvc.service.impl.DebtServiceImpl;
import com.example.paysvc.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("pay")
public class PayController {
    private final DebtServiceImpl debtService;
    private final PaymentServiceImpl paymentService;

    @GetMapping
    public List<PaymentResponse> getALL() {
        return paymentService.getAll();
    }


    @GetMapping("/{accountCode}")
    public ResponseEntity<DebtResponse> getDebtByAccountCode(@PathVariable int accountCode) {
        return new ResponseEntity<>(debtService.getDebtByAccountCode(accountCode), HttpStatus.OK);
    }

    @PostMapping
    public Long paymentRequest(@RequestBody PaymentEntity payment) {
        return paymentService.save(payment);
    }

    @PostMapping("/{id}")
    public ResponseEntity<PaymentEntity> paymentSubmit(@PathVariable Long id) {
        return new ResponseEntity<>(paymentService.changeStatus(id),HttpStatus.OK);
    }
}


