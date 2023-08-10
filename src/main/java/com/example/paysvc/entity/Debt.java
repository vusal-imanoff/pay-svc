package com.example.paysvc.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "debt")
public class Debt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int mergentId;  //merchant
    private double debt;
    private long userId;
    private long accountCode;

}
