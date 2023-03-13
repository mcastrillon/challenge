package com.ontop.account.repository;

import com.ontop.account.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {

    BankAccount findBankAccountByAccountNumberAndIdNumber(Long accountNumber, Long idNumber);
    BankAccount findBankAccountByIdNumber(Long idNumber);
}
