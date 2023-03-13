package com.ontop.account.service;

import com.ontop.account.model.BankAccount;

public interface IBankAccountService {

    void save(BankAccount bankAccount);

    BankAccount getBankAccount(Long accountNumber, Long idNumber);

    BankAccount getBankAccountByUser(Long idNumber);
}
