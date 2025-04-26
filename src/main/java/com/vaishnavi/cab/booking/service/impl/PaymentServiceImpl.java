package com.vaishnavi.cab.booking.service.impl;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.repository.PaymentRepository;
import com.vaishnavi.cab.booking.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment makePayment(Payment payment) throws SQLException {
        paymentRepository.makePayment(payment);
        return payment;
    }

    @Override
    public List<Payment> getAllPayments() throws SQLException {
        return paymentRepository.getAllPayments();
    }

    @Override
    public void updatePayment(Payment payment) throws SQLException {
        paymentRepository.updatePayment(payment);
    }

    @Override
    public void deletePayment(int paymentId) throws SQLException {
        paymentRepository.deletePayment(paymentId);
    }

    @Override
    public Payment updatePayment(int id, Payment payment) {
        return null;
    }

    @Override
    public Payment getPaymentById(int id) {
        return null;
    }
}



