/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MISHA
 */
public class DataBaseConnection {

    Scanner scanner;

    private static DataBaseConnection DBCInstance;
    private static Connection connection;

    private DataBaseConnection() {
        //keeping it private
    }

    public static DataBaseConnection getDBCInstance() {
        if (DBCInstance == null) {
            DBCInstance = new DataBaseConnection();
        }
        return DBCInstance;
    }

    public Connection getConnection() {

        scanner = new Scanner(System.in);
        if (connection == null) {
            try {

                System.out.println("----Creating a connection.----");

                String driver = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:mysql://localhost/?useSSL=false";
                String username = "root";
                String password = "athina2004";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);

                System.out.println("----Database connection established.----");

            } catch (ClassNotFoundException | SQLException ex) {

               Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("+++++Database connection failed.+++++");

            }

        }

        return connection;
    }

}
