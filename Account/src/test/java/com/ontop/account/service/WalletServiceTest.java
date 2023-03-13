package com.ontop.account.service;

import com.ontop.account.exception.TransactionBadRequestException;
import com.ontop.account.exception.TransactionGenericException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WalletServiceTest {

    private WalletService service;

    @BeforeEach
    void setUp() {
        service = new WalletService();
    }

    @Test
    void testGetBalanceValidUser(){

        Float balance = service.getBalance(1L);

        assertEquals(5000F, balance);
    }

    @Test
    void testWalletTransaction(){

        assertTrue(service.executeWalletTransaction(1L, 5000F));
    }

    @Test
    void testTransactionNullUser() {

        Assertions.assertThrows(TransactionBadRequestException.class,
            () -> service.executeWalletTransaction(null, 0F));
    }

    @Test
    void testTransactionBadRequest() {

        Assertions.assertThrows(TransactionBadRequestException.class,
            () -> service.executeWalletTransaction(-1L, 0F));
    }

    @Test
    void testTransactionGenericException() {

        Assertions.assertThrows(TransactionGenericException.class,
            () -> service.executeWalletTransaction(-2L, 0F));
    }
}
