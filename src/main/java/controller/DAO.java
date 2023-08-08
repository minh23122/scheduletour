/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD
 */
public class DAO {

    String dbUrl = "jdbc:mysql://localhost:3306/quanlytour";
    String dbClass = "com.mysql.cj.jdbc.Driver";
    public Connection getConnection() {
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlsString="jdbc:mysql://localhost:3306/quanlytour";
            connection= DriverManager.getConnection(urlsString,"root","1234");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return connection;
    }
        
}

