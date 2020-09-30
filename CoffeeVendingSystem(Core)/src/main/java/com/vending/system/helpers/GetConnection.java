package com.vending.system.helpers;

import java.sql.*;

public class GetConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffee_vending",
                "root","Sarthakk98#");
        return connection;
    }
}
