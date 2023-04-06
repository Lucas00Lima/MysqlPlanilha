package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbreDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db000";
        String user = "root";
        String pass = "@soma+";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url,user,pass);
        }
        catch (ClassCastException | ClassNotFoundException | SQLException ex) {
            System.out.println("Erro de Conexão");
        }
    }

}