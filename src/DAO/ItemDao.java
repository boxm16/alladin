/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Item;
import Models.ReceivingReport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michail Sitmalidis
 */
public class ItemDao {

    Connection connection;

    public ItemDao() {
        connection = DataBaseConnection.getDBCInstance().getConnection();
    }

    public void insertReceivingReport(ReceivingReport receivingReport) {
        String insertReceivingReportQuery = "INSERT INTO alladin.receiving_report (receiving_date, receiving_report_number, customer_id) "
                + "VALUES(?,?,?)";
        String insertReceivedItemQuery = "INSERT INTO alladin.item (product_id, item_code, cleaning, storing, mending, cleaning_charge, storing_charge, mending_charge, receiving_report_id, note)"
                + " VALUES(?,?,?,?,?,?,?,?, (SELECT MAX(receiving_report_id) AS AUTO_INCREMENT FROM alladin.receiving_report ),?);";
        try (PreparedStatement insertReceivingReport = connection.prepareStatement(insertReceivingReportQuery);
                PreparedStatement insertReceivedItem = connection.prepareStatement(insertReceivedItemQuery)) {

            insertReceivingReport.setString(1, receivingReport.getReceivingDate());
            insertReceivingReport.setInt(2, receivingReport.getReceivingReportNumber());
            insertReceivingReport.setInt(3, receivingReport.getCustomer().getCustomer_id());
            insertReceivingReport.execute();

            for (Item item : receivingReport.getReceivedItems()) {

                insertReceivedItem.setInt(1, item.getProduct_id());
                insertReceivedItem.setInt(2, item.getItemCode());
               
                insertReceivedItem.setString(3, item.getCleaning());
                insertReceivedItem.setString(4, item.getStoring());
                insertReceivedItem.setString(5, item.getMending());
                insertReceivedItem.setDouble(6, 0.0);
                insertReceivedItem.setDouble(7, 0.0);
                insertReceivedItem.setDouble(8, 0.0);
                insertReceivedItem.setString(9, item.getNote());
              
                insertReceivedItem.addBatch();

            }
            insertReceivedItem.executeBatch();

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
