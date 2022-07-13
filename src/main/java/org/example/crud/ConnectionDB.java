package org.example.crud;

import java.sql.DriverManager;

import org.example.utils.Messages;

import java.sql.Connection;

public class ConnectionDB {
    static Messages messages = Messages.getInstance();
    Connection conn = null;
    String usuario = "postgres";
    String contrasenia = "qwerty";
    String url = "jdbc:postgresql://localhost:5432/java";

    public Connection conectar() {
        try {
            //Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usuario, contrasenia);
        } catch (Exception e) {
            messages.showMessage("error de conexion");
        }
        return conn;
    }

}