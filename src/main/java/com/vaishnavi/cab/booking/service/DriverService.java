package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Driver;

import java.sql.SQLException;
import java.util.List;

public interface DriverService {
    void registerDriver(Driver driver) throws SQLException;

    List<Driver> getDrivers() throws SQLException;

    void updateDriver(Driver driver) throws SQLException;

    void deleteDriver(int driverId) throws SQLException;
}



