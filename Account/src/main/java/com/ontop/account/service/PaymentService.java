package com.ontop.account.service;


import com.ontop.account.exception.TransactionBadRequestException;
import com.ontop.account.exception.TransactionGenericException;
import com.ontop.account.model.BankAccount;
import com.ontop.account.model.PaymentResult;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService implements IPaymentService {
    @Override
    public PaymentResult payProvider(BankAccount bankAccount) {

        return executePaymentService(bankAccount);
    }

    private PaymentResult executePaymentService(BankAccount bankAccount) {

        if(bankAccount.getCurrencySource() == null) {

            throw new TransactionBadRequestException("body is invalid");
        }

        if(bankAccount.getAmount() == 0){

            throw new TransactionGenericException("bank rejected payment");
        }

        if(bankAccount.getAmount() == -1){

            throw new TransactionGenericException("timeout");
        }

        buildPaymentObject(bankAccount);

        return new PaymentResult("Processing", bankAccount.getAmount(), UUID.randomUUID().toString(),LocalDateTime.now());
    }

    private String  buildPaymentObject(BankAccount bankAccount){

        String json = "{\"source\": {\"type\": \"COMPANY\",\"sourceInformation\": {\"name\": \"ONTOP INC\"},"
                + "\"account\": {\"accountNumber\": \""+bankAccount.getAccountNumber()+"\",\"currency\": \""
                +bankAccount.getCurrencySource()+"\","
                + "\"routingNumber\": \""+bankAccount.getRoutingNumber()+"\"}},\"destination\": {\"name\": \""
                +bankAccount.getFirstName()+" "+bankAccount.getLastName()+"\","
                + "\"account\": {\"accountNumber\": \""+bankAccount.getAccountNumber()+"\",\"currency\": \""
                +bankAccount.getCurrencyDestination()+"\",\"routingNumber\": \""+bankAccount.getRoutingNumber()+"\"}},"
                + "\"amount\": "+bankAccount.getAmount()+"}";

        try {
            JSONObject object = new JSONObject(json);
            return object.toString();

        } catch (JSONException e) {
            return "";
        }
    }
}
