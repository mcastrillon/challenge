package com.ontop.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Status {

    private Long id;

    private Long userId;

    private String transactionId;

    private String Status;

    private Float amount;

    private LocalDate timestamp;

    public Status(Long userId, String transactionId, String status, Float amount, LocalDate timestamp) {
        this.userId = userId;
        this.transactionId = transactionId;
        Status = status;
        this.amount = amount;
        this.timestamp = timestamp;
    }
}
