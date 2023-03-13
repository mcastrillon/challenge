package com.ontop.account.service;

public interface IWalletService {

    Float getBalance(Long clientId);

    boolean executeWalletTransaction(Long userId, Float amount);

}
