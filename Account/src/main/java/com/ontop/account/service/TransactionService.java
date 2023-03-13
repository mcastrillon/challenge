package com.ontop.account.service;

import com.ontop.account.configuration.Configuration;
import com.ontop.account.exception.TransactionBalanceException;
import com.ontop.account.model.BankAccount;
import com.ontop.account.model.Payment;
import com.ontop.account.model.PaymentResult;
import com.ontop.account.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionService implements ITransactionService {

    private IBankAccountService bankAccountService;

    private IWalletService walletService;

    private IPaymentService paymentService;

    private IStatusService statusService;

    private Configuration config;

    private static final String STATUS_FAILED = "Failed";

    public Float createAccount(BankAccount bankAccount){

        Float balance = walletService.getBalance(bankAccount.getIdNumber());

        if (balance > 0) {

            if( bankAccountService.getBankAccount(bankAccount.getAccountNumber(), bankAccount.getIdNumber()) == null) {
                bankAccountService.save(bankAccount);
            }

            return balance;

        } else{

            throw new TransactionBalanceException("There is not money in your wallet");
        }
    }

    public void transferMoney(Payment payment){

        BankAccount bankAccount = bankAccountService.getBankAccountByUser(payment.getIdNumber());
        Float balance = walletService.getBalance(payment.getIdNumber());

        if (balance > 0
            && balance >= payment.getAmount()
            && walletService.executeWalletTransaction(payment.getIdNumber(), payment.getAmount()*-1)) {

            bankAccount.setAmount(payment.getAmount() - getFee(payment.getAmount()));
            bankAccount.setCurrencySource(payment.getCurrencySource());
            bankAccount.setCurrencyDestination(payment.getCurrencyDestination());

            PaymentResult paymentResult = paymentService.payProvider(bankAccount);

            if(paymentResult != null && !paymentResult.getStatus().equals(STATUS_FAILED)){

                statusService.saveStatus(getStatus(payment.getIdNumber(),paymentResult));
            } else {
                walletService.executeWalletTransaction(payment.getIdNumber(), payment.getAmount());
            }
        } else {

            throw new TransactionBalanceException("There is not enough money in your wallet for this transaction");
        }
    }

    private Float getFee(Float amount){
        return (config.getFee()/amount)*100;
    }

    private Status getStatus(Long userId, PaymentResult paymentResult){

        return new Status(
            userId, paymentResult.getId(),paymentResult.getStatus(),paymentResult.getAmount(), LocalDate.now());
    }

    @Autowired
    public void setBankAccountService(IBankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Autowired
    public void setWalletService(IWalletService walletService) {
        this.walletService = walletService;
    }

    @Autowired
    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Autowired
    public void setStatusService(IStatusService statusService) {
        this.statusService = statusService;
    }

    @Autowired
    public void setConfig(Configuration config) {
        this.config = config;
    }
}
