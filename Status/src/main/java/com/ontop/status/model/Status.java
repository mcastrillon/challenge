package com.ontop.status.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String transactionId;

    private String status;

    private Float amount;

    private LocalDate timestamp;


    public Status(Long userId, String transactionId, String status, Float amount, LocalDate timestamp) {
        this.userId = userId;
        this.transactionId = transactionId;
        this.status = status;
        this.amount = amount;
        this.timestamp = timestamp;
    }
}
