package com.milo.Library.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DbConnection {
    //Because of pi crash this database is down at the moment. It may take couple of days to fix it.
    private final String DB_URL = "jdbc:mysql://89.73.244.48:3306/librarydb";
    private final String DB_USER = "user";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, "library2021");
    }
}
