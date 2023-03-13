package com.ontop.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Payment {

    private Long idNumber;
    private Float amount;
    private String currencySource;
    private String currencyDestination;

}
