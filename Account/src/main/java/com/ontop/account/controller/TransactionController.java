package com.ontop.account.controller;

import com.ontop.account.model.BankAccount;
import com.ontop.account.model.Payment;
import com.ontop.account.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private ITransactionService service;

    @PostMapping("/account")
    public void createAccount(@RequestBody BankAccount bankAccount){

        service.createAccount(bankAccount);
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody Payment payment) {

        service.transferMoney(payment);
    }

    @Autowired
    public void setService(ITransactionService service) {
        this.service = service;
    }
}
