package com.ontop.account.service;

import com.ontop.account.model.BankAccount;
import com.ontop.account.model.PaymentResult;
import org.springframework.stereotype.Service;

public interface IPaymentService {

    public PaymentResult payProvider(BankAccount bankAccount);
}
