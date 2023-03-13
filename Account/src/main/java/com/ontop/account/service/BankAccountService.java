package com.ontop.account.service;

import com.ontop.account.model.BankAccount;
import com.ontop.account.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService implements IBankAccountService{

    private BankAccountRepository repository;

    public void save(BankAccount bankAccount){
        repository.save(bankAccount);
    }
    public BankAccount getBankAccount(Long accountNumber, Long idNumber) {

        return repository.findBankAccountByAccountNumberAndIdNumber(accountNumber, idNumber);

    }

    public BankAccount getBankAccountByUser(Long idNumber) {

        return repository.findBankAccountByIdNumber(idNumber);

    }

    @Autowired
    public void setRepository(BankAccountRepository repository) {
        this.repository = repository;
    }
}
