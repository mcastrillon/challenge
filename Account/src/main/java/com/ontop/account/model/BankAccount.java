package com.ontop.account.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Long routingNumber;
    private Long idNumber;
    private Long accountNumber;

    @Transient
    private String currencySource;

    @Transient
    private String currencyDestination;

    @Transient
    private Float amount;
}
