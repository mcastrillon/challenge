package com.ontop.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PaymentResult {
    private String status;
    private Float amount;
    private String id;
    private LocalDateTime timestamp;
}
