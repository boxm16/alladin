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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    
    public void insertItemsDimesnions(ArrayList<Item> itemsList) {
        String insertItemsDimensionsQuery = "UPDATE alladin.item SET length=?, width=? WHERE item_code=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertItemsDimensionsQuery)) {
            
            for (Item item : itemsList) {
                preparedStatement.setDouble(1, item.getLength());
                preparedStatement.setDouble(2, item.getWidth());
                preparedStatement.setInt(3, item.getItemCode());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public ArrayList<Item> getItemList(int customer_id) {
        ArrayList<Item> itemList = new ArrayList();
        String itemListQuery = "SELECT * FROM alladin.item "
                + "INNER JOIN alladin.product ON item.product_id=product.product_id "
                + "INNER JOIN alladin.receiving_report ON receiving_report.receiving_report_id=item.receiving_report_id"
                + " WHERE customer_id=?; ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(itemListQuery)) {
            preparedStatement.setInt(1, customer_id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                Item item = new Item();
                item.setItemId(rs.getInt("item_id"));
                item.setProduct_id(rs.getInt("product_id"));
                item.setProduct_description(rs.getString("product_description"));
                item.setCleaning_price(rs.getDouble("cleaning_price"));
                item.setStoring_price(rs.getDouble("storing_price"));
                item.setMending_price(rs.getDouble("mending_price"));
                item.setItemCode(rs.getInt("item_code"));
                item.setLength(rs.getDouble("length"));
                
                item.setWidth(rs.getDouble("width"));
                item.setCleaning(rs.getString("cleaning"));
                item.setStoring(rs.getString("storing"));
                item.setMending(rs.getString("mending"));
                if (item.getCleaning().equals("*")) {
                    item.setCleaningCharge(rs.getDouble("cleaning_price") * item.getLength() * item.getWidth());
                } else {
                    item.setCleaningCharge(0.0);
                }
                if (item.getStoring().equals("*")) {
                    item.setStoringCharge(rs.getDouble("storing_price") * item.getLength() * item.getWidth());
                } else {
                    item.setStoringCharge(0.0);
                }
                if (item.getMending().equals("*")) {
                    item.setMendingCharge(rs.getDouble("mending_price"));
                }
                item.setStatus(rs.getString("status"));
                item.setNote(rs.getString("note"));
                itemList.add(item);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return itemList;
    }
    
}
