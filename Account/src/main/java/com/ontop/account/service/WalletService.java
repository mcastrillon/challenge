package com.ontop.account.service;

import com.ontop.account.exception.TransactionBadRequestException;
import com.ontop.account.exception.TransactionGenericException;
import com.ontop.account.model.Balance;
import com.ontop.account.model.Wallet;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService implements IWalletService{

    // Request manager to Wallet services

    @Override
    public Float getBalance(Long clientId) {

        Balance balance = executeBalanceService(clientId);

        return balance != null && balance.getBalance() > 0 ? balance.getBalance() : 0F;

    }

    private Balance executeBalanceService(Long clientId) {

        return new Balance(5000F, clientId);
    }

    @Override
    public boolean executeWalletTransaction(Long userId, Float amount) {

        return Optional.ofNullable(executeWithdrawService(userId, amount))
                .orElse(new Wallet()).getWallet_transaction_id() > 0;
    }
    private Wallet executeWithdrawService(Long userId, Float amount) {

        if(userId == null || amount == null){

            throw new TransactionBadRequestException("amount and user_id must not be null");
        }

        if(userId == -1){

            throw new TransactionBadRequestException("user not found");
        }

        if(userId == -2){

            throw new TransactionGenericException("something bad happened");
        }

        return new Wallet(59974L, amount, userId);

    }

}
