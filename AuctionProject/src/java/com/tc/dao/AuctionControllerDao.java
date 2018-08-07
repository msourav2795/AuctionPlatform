/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dao;

import com.tc.dto.AdminObject;
import com.tc.dto.AuctionController;
import com.tc.dto.AuctionProduct;
import com.tc.dto.Bid;
import com.tc.dto.Suppliers;
import com.tc.helpers.DatabseConnectionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AJAYSHARMA
 */
public class AuctionControllerDao {
    public static boolean validateAuctionController(String username,String password)
    {
         boolean result = false;

        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM auctioncontroller where username=? and password=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(BidderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
     }
    
     public static AuctionController getAuctionController(String username,String password)
     {
         DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM bidders where username=? and password=?";
        
        PreparedStatement stmt = null;
         AuctionController ac=new AuctionController();
        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
               
                ac.setAcId(rs.getInt("acId"));
                ac.setAcName(rs.getString("acName"));
                ac.setRoleId(rs.getInt("roleId"));
                ac.setUsername(rs.getString("username"));
                ac.setPassword(rs.getString("password"));
                ac.setBu(rs.getString("bu"));
               
                ac.setIsLoggedIn(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BidderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ac;
     }
     
     public static AdminObject getAdminData(AuctionProduct ap) throws SQLException
     {               
         System.out.println("Dao 1");
                int auctionid = ap.getAuctionId();
                System.out.println("Auction Id in dao"+auctionid);
                Date date = ap.getAuctionDate();
                System.out.println("Auction Date"+date);
                int suppId = ap.getSuppId();
                System.out.println("Supp Id is"+suppId);
                Suppliers supplier=new Suppliers();
               // System.out.println("Dao 3");
                supplier = SupplierDao.getSuupplierForAuctionController(suppId);
                String SuppName = supplier.getSuppName();
                String orgName = supplier.getOrgName();
                //System.out.println("Dao 4");
                int productId = ap.getProductId();
                System.out.println("product  Id is"+productId);
                String productName = ap.getProductName();
                Bid bid=new Bid();
              //  System.out.println("Dao 5");
                bid = BidderDao.getBidInfo(auctionid, productId);
                int bidId = bid.getBidId();
                int bidderId=bid.getBiddersId();
                double price = bid.getBidPrice();
                
                AdminObject admin=new AdminObject();
                admin.setAuctionid(auctionid);
                admin.setBidId(bidId);
                admin.setDate(date);
                admin.setOrgName(orgName);
                admin.setPrice(price);
                admin.setProductId(productId);
                admin.setProductName(productName);
                admin.setSuppId(suppId);
                admin.setSuppName(SuppName);
                admin.setBidderId(bidderId);
                //setAdmin(admin);
                //setSupplier(supplier);
                //setBid(bid);
                return admin;
     }
}