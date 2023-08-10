package com.example.paysvc.controller;

import com.example.paysvc.entity.Debt;
import com.example.paysvc.entity.Payment;
import com.example.paysvc.enums.Status;
import com.example.paysvc.repository.DebtRepository;
import com.example.paysvc.repository.PaymentRepository;
import com.example.paysvc.service.impl.DebtServiceImpl;
import com.example.paysvc.service.impl.PaymentServiceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.generic.RET;
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

    @GetMapping()
    public List<Payment> getALL()
    {
        return paymentService.getAll();
    }


    @GetMapping("/{accountCode}")
    public ResponseEntity<Debt> getDebtByAccountCode(@PathVariable int accountCode)
    {
        return new ResponseEntity<>(debtService.getDebtByAccountCode(accountCode), HttpStatus.OK);
    }

    @PostMapping()
    public Long paymentRequest(@RequestBody Payment payment)
    {
        return paymentService.save(payment);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Payment> paymentSubmit(@PathVariable Long id)
    {
        return new ResponseEntity<>(paymentService.changeStatus(id),HttpStatus.OK);
    }
}


