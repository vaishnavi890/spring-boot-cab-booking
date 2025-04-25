package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Ride;

import java.sql.SQLException;
import java.util.List;

public interface RideService {
    void bookRide(Ride ride) throws SQLException;

    List<Ride> getRides() throws SQLException;

    void updateRide(Ride ride) throws SQLException;

    void deleteRide(int rideId) throws SQLException;
}


