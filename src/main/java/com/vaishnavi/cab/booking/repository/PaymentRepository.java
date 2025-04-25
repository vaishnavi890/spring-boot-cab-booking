package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.connection.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {

    public void makePayment(Payment payment) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("INSERT INTO payments(ride_id, user_id, amount, payment_method, status) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, payment.getRideId());
            ps.setInt(2, payment.getUserId());
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getPaymentMethod());
            ps.setString(5, payment.getStatus());
            ps.executeUpdate();
        } finally {
            DBConnection.close(ps, con);
        }
    }

    public List<Payment> getAllPayments() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM payments");

            while (rs.next()) {
                Payment payment = new Payment();
                payment.setPaymentId(rs.getInt("payment_id"));
                payment.setRideId(rs.getInt("ride_id"));
                payment.setUserId(rs.getInt("user_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentMethod(rs.getString("payment_method"));
                payment.setStatus(rs.getString("status"));
                payments.add(payment);
            }
        } finally {
            DBConnection.close(rs, st, con);
        }

        return payments;
    }

    public void updatePayment(Payment payment) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("UPDATE payments SET amount=?, payment_method=?, status=? WHERE payment_id=?");
            ps.setDouble(1, payment.getAmount());
            ps.setString(2, payment.getPaymentMethod());
            ps.setString(3, payment.getStatus());
            ps.setInt(4, payment.getPaymentId());
            ps.executeUpdate();
        } finally {
            DBConnection.close(ps, con);
        }
    }

    public void deletePayment(int paymentId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("DELETE FROM payments WHERE payment_id=?");
            ps.setInt(1, paymentId);
            ps.executeUpdate();
        } finally {
            DBConnection.close(ps, con);
        }
    }
}



