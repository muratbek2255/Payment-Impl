package com.example.payment.service;


import com.example.payment.dto.PaymentCheckRequest;
import com.example.payment.dto.PaymentRequest;


public interface PaymentService {

    public String checkPayment(PaymentCheckRequest paymentCheckRequest);

    public String addStatus(PaymentRequest paymentRequest, int id);

    public String setStatus(int id);

    public String rollbackPayment(int id);

    public String getByStatus(String status);
}
