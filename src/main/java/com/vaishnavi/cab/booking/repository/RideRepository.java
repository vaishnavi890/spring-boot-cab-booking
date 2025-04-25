package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.connection.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RideRepository {

    public void bookRide(Ride ride) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("INSERT INTO rides(user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, ride.getUserId());
            ps.setInt(2, ride.getDriverId());
            ps.setString(3, ride.getPickupLocation());
            ps.setString(4, ride.getDropoffLocation());
            ps.setDouble(5, ride.getFare());
            ps.setString(6, ride.getStatus());
            ps.executeUpdate();
        } finally {
            DBConnection.close(ps, con);
        }
    }

    public List<Ride> getAllRides() throws SQLException {
        List<Ride> rides = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM rides");

            while (rs.next()) {
                Ride ride = new Ride();
                ride.setRideId(rs.getInt("ride_id"));
                ride.setUserId(rs.getInt("user_id"));
                ride.setDriverId(rs.getInt("driver_id"));
                ride.setPickupLocation(rs.getString("pickup_location"));
                ride.setDropoffLocation(rs.getString("dropoff_location"));
                ride.setFare(rs.getDouble("fare"));
                ride.setStatus(rs.getString("status"));
                rides.add(ride);
            }
        } finally {
            DBConnection.close(rs, st, con);
        }
        return rides;
    }

    public void updateRide(Ride ride) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("UPDATE rides SET pickup_location=?, dropoff_location=?, fare=?, status=? WHERE ride_id=?");
            ps.setString(1, ride.getPickupLocation());
            ps.setString(2, ride.getDropoffLocation());
            ps.setDouble(3, ride.getFare());
            ps.setString(4, ride.getStatus());
            ps.setInt(5, ride.getRideId());
            ps.executeUpdate();
        } finally {
            DBConnection.close(ps, con);
        }
    }

    public void deleteRide(int rideId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("DELETE FROM rides WHERE ride_id=?");
            ps.setInt(1, rideId);
            ps.executeUpdate();
        } finally {
            DBConnection.close(ps, con);
        }
    }
}



