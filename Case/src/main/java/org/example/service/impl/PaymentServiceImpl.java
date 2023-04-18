package org.example.service.impl;

import org.example.model.Payment;

import java.util.List;

public interface PaymentServiceImpl {
    List<Payment> getPayment();

    void add(Payment newPayment);

}
