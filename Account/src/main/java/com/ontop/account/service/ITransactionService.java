package com.ontop.account.service;

import com.ontop.account.model.BankAccount;
import com.ontop.account.model.Payment;

public interface ITransactionService {

    Float createAccount(BankAccount bankAccount);

    void transferMoney(Payment payment);
}
