/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dao;

import com.tc.dto.Products;
import com.tc.dto.Suppliers;
import com.tc.helpers.DatabseConnectionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saif.Ali
 */
public class SupplierDao {
    public static boolean RegisterSupplier(Suppliers supp) {

        boolean result = false;
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();
        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        String insertSQL = "INSERT INTO bidders (suppId, suppName, orgName, username, password) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement stmt = null; //will explain later
        int row = 0;

        if (conn == null) {
            return false;
        }

        try {
            stmt = conn.prepareStatement(insertSQL);
            stmt.setInt(1, supp.getSuppId());
            stmt.setString(2, supp.getSuppName());
            stmt.setString(3, supp.getOrgName());
            stmt.setString(4, supp.getUsername());
            stmt.setString(5, supp.getPassword());
            row = stmt.executeUpdate();
            if (row > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        } finally {
            try {
                conn.close(); //very important
            } catch (SQLException ex) {
                result = false;
            }
        }
        return result;
    }
    public static boolean validateSupplier(String username, String password){
         boolean result = false;

        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM suppliers where username=? and password=?";

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
    
    public static Suppliers getSupplier(String username, String password){
        //boolean result = false;
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        String selectSQL = "SELECT * FROM suppliers where username=? and password=?";
        
        PreparedStatement stmt = null;
        Suppliers b=new Suppliers();
        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
               
                b.setSuppId(rs.getInt("suppId"));
                b.setSuppName(rs.getString("suppName"));
                b.setOrgName(rs.getString("orgName"));
                b.setRoleId(rs.getInt("roleId"));
                b.setStatus(rs.getInt("status"));
                b.setUsername(rs.getString("username"));
                b.setPassword(rs.getString("password"));
                b.setIsLoggedIn(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BidderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }
    
    public static boolean RegisterProduct(Products prod) {

        boolean result = false;
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();
        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        String insertSQL = "INSERT INTO products (pdId, pdName, suppId) VALUES (?, ?, ?);";

        PreparedStatement stmt = null; //will explain later
        int row = 0;

        if (conn == null) {
            return false;
        }

        try {
            stmt = conn.prepareStatement(insertSQL);
            stmt.setInt(1, prod.getPdId());
            stmt.setString(2, prod.getPdName());
            stmt.setInt(3, prod.getSuppId());
            row = stmt.executeUpdate();
            if (row > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        } finally {
            try {
                conn.close(); 
            } catch (SQLException ex) {
                result = false;
            }
        }
        return result;
    }
    public static ArrayList<Products> RegisteredProducts(int suppId) {

        ArrayList<Products> products=new ArrayList<Products>();
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();
        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        String selectSQL = "SELECT * FROM products WHERE suppId = ?;"+suppId;

        PreparedStatement stmt = null;
        int row = 0;

        try {
            stmt = conn.prepareStatement(selectSQL);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Products info=new Products();
                String pdName=rs.getString("pdName");
                int pdId=rs.getInt("pdId");
                
                info.setPdId(pdId);
                info.setPdName(pdName);
                info.setSuppId(suppId);
                products.add(info);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BidderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
     }
}