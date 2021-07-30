package com.open.lms.service.payment.impl;

import com.open.lms.model.PaymentMethod;
import com.open.lms.service.payment.PaymentService;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaypalService implements PaymentService {

    private final APIContext apiContext;

    @Override
    @SneakyThrows
    public Payment createPayment(Money finalPrice) {
        var amount = new Amount();
        amount.setCurrency(finalPrice.getCurrency().getCurrencyCode());
        amount.setTotal(finalPrice.getNumberStripped().toString());
        var transaction = new Transaction();
        transaction.setAmount(amount);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        var payer = new Payer();
        payer.setPaymentMethod("paypal");

        var payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        var redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:4200/order/cancelled");
        redirectUrls.setReturnUrl("http://localhost:4200/order/success");
        payment.setRedirectUrls(redirectUrls);
        return payment.create(apiContext);
    }

    @SneakyThrows
    public void completePayment(String paymentId, String payerId) {
        var payment = new Payment();
        payment.setId(paymentId);
        var paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);
        payment.execute(apiContext, paymentExecution);
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return PaymentMethod.PAYPAL;
    }
}
