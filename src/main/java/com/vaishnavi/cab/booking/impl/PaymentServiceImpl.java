package com.vaishnavi.cab.booking.impl;

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
    public void makePayment(Payment payment) throws SQLException {
        paymentRepository.makePayment(payment);
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
}



