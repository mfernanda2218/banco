package com.example.banco.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String URL = "jdbc:postgresql://containers-us-west-XX.railway.app:5432/railway";
    private static final String USER = "postgres";
    private static final String PASSWORD = "SUA_SENHA_AQUI";

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexão bem-sucedida!");
            return conn;
        } catch (SQLException e) {
            System.err.println("❌ Erro de conexão: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        connect();
    }
}
