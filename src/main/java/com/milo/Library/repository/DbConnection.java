package com.milo.Library.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private final String DB_URL = "jdbc:mysql://remotemysql.com:3306/3Q84ulcsc7";
    private final String DB_USER = "3Q84ulcsc7";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, "zumqXjeFMY");
    }
}
