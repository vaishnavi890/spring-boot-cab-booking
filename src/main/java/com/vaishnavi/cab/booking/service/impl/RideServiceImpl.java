package com.vaishnavi.cab.booking.service.impl;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.repository.RideRepository;
import com.vaishnavi.cab.booking.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;

    @Override
    public Ride bookRide(Ride ride) throws SQLException {
        rideRepository.bookRide(ride);
        return ride;
    }

    @Override
    public List<Ride> getRides() throws SQLException {
        return rideRepository.getAllRides();
    }

    @Override
    public void updateRide(Ride ride) throws SQLException {
        rideRepository.updateRide(ride);
    }

    @Override
    public void deleteRide(int rideId) throws SQLException {
        rideRepository.deleteRide(rideId);
    }

    @Override
    public Ride updateRide(int id, Ride ride) {
        return null;
    }

    @Override
    public Ride getRideById(int id) {
        return null;
    }

    @Override
    public List<Ride> getAllRides() {
        return List.of();
    }
}



