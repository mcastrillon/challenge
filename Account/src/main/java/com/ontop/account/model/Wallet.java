package com.ontop.account.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long wallet_transaction_id;
    private Float amount;
    private Long user_id;

}
