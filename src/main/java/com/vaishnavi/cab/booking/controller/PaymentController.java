package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/make")
    public String makePayment(@RequestBody Payment payment) {
        try {
            paymentService.makePayment(payment);
            return "Payment completed successfully!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/all")
    public List<Payment> getAllPayments() throws SQLException {
        return paymentService.getAllPayments();
    }

    @PutMapping("/update")
    public String updatePayment(@RequestBody Payment payment) {
        try {
            paymentService.updatePayment(payment);
            return "Payment updated successfully!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deletePayment(@PathVariable int id) {
        try {
            paymentService.deletePayment(id);
            return "Payment deleted successfully!";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }
}



