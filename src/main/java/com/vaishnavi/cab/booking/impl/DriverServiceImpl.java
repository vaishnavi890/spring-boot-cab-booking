package com.vaishnavi.cab.booking.impl;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.repository.DriverRepository;
import com.vaishnavi.cab.booking.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void registerDriver(Driver driver) throws SQLException {
        driverRepository.addDriver(driver);
    }

    @Override
    public List<Driver> getDrivers() throws SQLException {
        return driverRepository.getAllDrivers();
    }

    @Override
    public void updateDriver(Driver driver) throws SQLException {
        driverRepository.updateDriver(driver);
    }

    @Override
    public void deleteDriver(int driverId) throws SQLException {
        driverRepository.deleteDriver(driverId);
    }
}



