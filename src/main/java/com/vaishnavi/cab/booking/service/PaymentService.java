package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Payment;

import java.sql.SQLException;
import java.util.List;

public interface PaymentService {
    void makePayment(Payment payment) throws SQLException;

    List<Payment> getAllPayments() throws SQLException;

    void updatePayment(Payment payment) throws SQLException;

    void deletePayment(int paymentId) throws SQLException;
}



