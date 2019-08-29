/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michail Sitmalidis
 */
public class DataBaseInitialization {

    Connection connection;

    public DataBaseInitialization() {
        connection = DataBaseConnection.getDBCInstance().getConnection();
    }

    public boolean checkDBExist() {

        try (ResultSet resultSet = connection.getMetaData().getCatalogs()) {
            while (resultSet.next()) {
                String databaseName = resultSet.getString(1);
                if (databaseName.equals("alladin")) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void createDB() {
        createDataBase();
        createCustomerTable();
    }

    private void createDataBase() {

        System.out.println("----Creating Database 'alladin'.----");
        String createDataBaseQuery = "CREATE SCHEMA IF NOT EXISTS alladin DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ; ";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createDataBaseQuery);
            System.out.println("----Database 'alladin' created successfully");

        } catch (SQLException ex) {
            System.out.println("----Creation of database 'alladin'  failed----");
            Logger.getLogger(DataBaseInitialization.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void createCustomerTable() {
        String createCustomerTableQuery = "CREATE TABLE IF NOT EXISTS alladin.customer ("
                + "  customer_id INT NOT NULL AUTO_INCREMENT,"
                + "  first_name VARCHAR(45) NULL,"
                + "  last_name VARCHAR(45) NULL,"
                + "  street VARCHAR(60) NULL,"
                + "  district VARCHAR(30) NULL,"
                + "  landline_phone VARCHAR(10) NULL,"
                + "  mobile_phone VARCHAR(10) NULL,"
                + "  floor VARCHAR(10) NULL,"
                + "  postal_code VARCHAR(5) NULL,"
                + "  name_on_Bell VARCHAR(60) NULL,"
                + "  note VARCHAR(250) NULL,"
                + "  PRIMARY KEY (customer_id));";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createCustomerTableQuery);
            System.out.println("----Table 'alladin.customer' created successfully");

        } catch (SQLException ex) {
            System.out.println("----Creation of table 'alladin.customer'  failed----");
            Logger.getLogger(DataBaseInitialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
