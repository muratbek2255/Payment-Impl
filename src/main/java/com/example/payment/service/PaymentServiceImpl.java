package com.example.payment.service;

import com.example.payment.dto.PaymentCheckRequest;
import com.example.payment.dto.PaymentRequest;
import com.example.payment.entity.Favour;
import com.example.payment.entity.Payment;
import com.example.payment.entity.enumClass.Status;
import com.example.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;


@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private ApplicationEventPublisher applicationEventPublisher;

    private final FavourService favourService;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, FavourService favourService) {
        this.paymentRepository = paymentRepository;
        this.favourService = favourService;
    }


    @Override
    public String checkPayment(PaymentCheckRequest paymentCheckRequest) {

        if(paymentCheckRequest.getSumOfFavour() > 500 && paymentCheckRequest.getSumOfFavour() < 25000 &&
                paymentCheckRequest.getAccountCheck() != null) {

            Payment payment = new Payment();

            payment.setIsChecked(Boolean.TRUE);
            payment.setStatus(Status.STATUS_IN_PROCESS);

            paymentRepository.save(payment);

            return "Order is checked!";

        } else  {

            return "Error, you have problem with sumOfFavour or AccountCheck!";

        }

    }

    @Override
    public String addStatus(PaymentRequest paymentRequest, int id) {

        Payment payment = paymentRepository.getById(id);

        Favour favour = favourService.getByIdFavor(paymentRequest.getFavourRequest().getId());

        if(payment.getIsChecked().equals(Boolean.TRUE)) {

            payment.setStatus(Status.STATUS_CREATED);
            payment.setCreated_at(Timestamp.from(Instant.now()));
            payment.setFinished(Boolean.FALSE);
            payment.setFavour(favour);
            payment.setSumOfFavour(paymentRequest.getPrice());
            payment.setAccountCheck(paymentRequest.getAccountCheck());

            paymentRepository.save(payment);

            return "Payment Created";
        }else {
            return "You have some with problem with AccountCheck or SumOfFavour";
        }
    }

    @Override
    public String setStatus(int id) {

        Payment payment = paymentRepository.getById(id);

        payment.setFinished(Boolean.TRUE);

        if(payment.getFinished() == Boolean.TRUE) {
            payment.setStatus(Status.STATUS_SUCCESS);
        }

        payment.setUpdated_at(Timestamp.from(Instant.now()));

        paymentRepository.save(payment);

        return "Your status in payment: " + payment.getStatus();
    }

    @Override
    public String rollbackPayment(int id) {
        Payment payment = paymentRepository.getById(id);

        if(payment.getStatus() == Status.STATUS_SUCCESS) {

            long Milli = Math.abs(payment.getUpdated_at().getTime() - new Date().getTime());

            if(Milli < 1080000) {
                payment.setStatus(Status.STATUS_ROLLBACK);
            } else {
                return "3 days gone";
            }
        } else if(payment.getStatus() == Status.STATUS_CREATED) {
            payment.setStatus(Status.STATUS_ROLLBACK);
        } else {
            return "You dont have payment or your status fail";
        }

        payment.setUpdated_at(Timestamp.from(Instant.now()));

        paymentRepository.save(payment);

        return "Rollback payment";
    }

    @Override
    public String getByStatus(String status) {

        List<Payment> payment = paymentRepository.getByStatus(status);

        return "Payment with status: " + payment;

    }
}
