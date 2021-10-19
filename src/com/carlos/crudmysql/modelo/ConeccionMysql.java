package com.carlos.crudmysql.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConeccionMysql {

    private final String user = "test";
    private final String pass = "1234";
    private final String url = "jdbc:mysql://localhost:3306/persona";

    public Connection getConnection() throws SQLException {
        try {
            Connection coneccion = DriverManager.getConnection(url, user, pass);

            return coneccion;

        } catch (SQLException ex) {
            ex.printStackTrace();

            return null;
        }

    }





}
