package com.example.paysvc.controller;

import com.example.paysvc.dto.Request.CreatePaymentRequest;
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
@RequestMapping("v1/pay")
public class PayController {

    private final DebtServiceImpl debtService;
    private final PaymentServiceImpl paymentService;

    @GetMapping
    public List<PaymentResponse> getALL() {
        return paymentService.getAll();
    }


    @GetMapping("/{accountCode}")
    public DebtResponse getDebtByAccountCode(@PathVariable int accountCode) {
        return debtService.getDebtByAccountCode(accountCode);
    }

    @PostMapping
    public Long paymentRequest(@RequestBody CreatePaymentRequest request) {
        return paymentService.save(request);
    }

    @PostMapping("/{id}")
    public void paymentSubmit(@PathVariable Long id) {
        paymentService.changeStatus(id);
    }
}


