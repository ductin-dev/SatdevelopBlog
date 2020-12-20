package com.satellite.myblog.model;
//Author: Doan Duc Tin

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDAO {

    Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void openConnection() throws Exception {
        Class.forName(DatabaseInfo.driverName).newInstance();
        connection = DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.name, DatabaseInfo.pass);
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            //NOTHING WE CAN DO
        }
    }
}
