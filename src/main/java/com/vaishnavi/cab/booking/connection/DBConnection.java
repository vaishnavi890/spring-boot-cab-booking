package com.vaishnavi.cab.booking.connection;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/cab_booking_db";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Vaishnavi");
            stmt.setString(2, "vaishnavi@example.com");
            stmt.executeUpdate();

            System.out.println("User inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Always close in reverse order of opening
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement ps, Connection con) {
    }

    public static void close(ResultSet rs, Statement st, Connection con) {

    }
}



