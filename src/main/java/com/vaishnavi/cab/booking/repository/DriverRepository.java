package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.connection.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverRepository {

    public void addDriver(Driver driver) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("INSERT INTO drivers(name, email, phone, cab_details) VALUES (?, ?, ?, ?)");
            ps.setString(1, driver.getName());
            ps.setString(2, driver.getEmail());
            ps.setString(3, driver.getPhone());
            ps.setString(4, driver.getCabDetails());
            ps.executeUpdate();
        } finally {
            DBConnection.close(ps, con);
        }
    }

    public List<Driver> getAllDrivers() throws SQLException {
        List<Driver> list = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM drivers");
            while (rs.next()) {
                Driver d = new Driver();
                d.setDriverId(rs.getInt("driver_id"));
                d.setName(rs.getString("name"));
                d.setEmail(rs.getString("email"));
                d.setPhone(rs.getString("phone"));
                d.setCabDetails(rs.getString("cab_details"));
                list.add(d);
            }
        } finally {
            DBConnection.close(rs, st, con);
        }
        return list;
    }

    public void updateDriver(Driver driver) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("UPDATE drivers SET name=?, email=?, phone=?, cab_details=? WHERE driver_id=?");
            ps.setString(1, driver.getName());
            ps.setString(2, driver.getEmail());
            ps.setString(3, driver.getPhone());
            ps.setString(4, driver.getCabDetails());
            ps.setInt(5, driver.getDriverId());
            ps.executeUpdate();
        } finally {
            DBConnection.close(ps, con);
        }
    }

    public void deleteDriver(int id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("DELETE FROM drivers WHERE driver_id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            DBConnection.close(ps, con);
        }
    }
}



