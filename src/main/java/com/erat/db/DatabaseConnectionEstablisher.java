package com.erat.db;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionEstablisher {

    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/cruise_company", "root", "toor");
    }
}
