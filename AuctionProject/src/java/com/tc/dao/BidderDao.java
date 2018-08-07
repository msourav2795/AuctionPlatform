/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dao;

import com.tc.dto.AuctionProduct;
import com.tc.dto.Bid;
import com.tc.dto.Bidders;
import com.tc.dto.Role;
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
 * @author kishlay.verma
 */
public class BidderDao {

    public static boolean RegisterBid(Bid bid) {

        boolean result = false;
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();
        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        String insertSQL = "INSERT INTO bid (bidId, bidPrice, biddersId, auctionId, pdId) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement stmt = null; //will explain later
        int row = 0;

        if (conn == null) {
            return false;
        }

        try {
            stmt = conn.prepareStatement(insertSQL);
            stmt.setInt(1, bid.getBidId());
            stmt.setDouble(2, bid.getBidPrice());
            stmt.setInt(3, bid.getBiddersId());
            stmt.setInt(4, bid.getAuctionId());
            stmt.setInt(5, bid.getPdId());
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

    public static boolean RegisterBidder(Bidders bidder) {

        boolean result = false;
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();
        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        String insertSQL = "INSERT INTO bidders (name, username, password) VALUES (?, ?, ?);";

        PreparedStatement stmt = null; //will explain later
        int row = 0;

        if (conn == null) {
            return false;
        }

        try {
            stmt = conn.prepareStatement(insertSQL);
            stmt.setString(1, bidder.getName());
            stmt.setString(2, bidder.getUsername());
            stmt.setString(3, bidder.getPassword());
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

    public static boolean validateBidders(String username, String password) {
        boolean result = false;

        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM bidders where username=? and password=?";

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

    public static Bidders getBidder(String username, String password) {
        boolean result = false;

        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM bidders where username=? and password=?";

        PreparedStatement stmt = null;
        Bidders b = new Bidders();
        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                b.setId(rs.getInt("bidderId"));
                b.setName(rs.getString("name"));
                b.setRoleId(rs.getInt("roleId"));
                b.setUsername(rs.getString("username"));
                b.setPassword(rs.getString("password"));
                b.setStatus(rs.getInt("status"));
                b.setAddress(rs.getString("address"));
                b.setContact(rs.getString("contact"));
                b.setIsLoggedIn(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BidderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }
    
    public static Bidders getBidderInfo(String bidderId) {
        Bidders b = new Bidders();

        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM bidders where bidderId=?";

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, bidderId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                b.setId(rs.getInt("bidderId"));
                b.setName(rs.getString("name"));
                b.setUsername(rs.getString("username"));
                b.setAddress(rs.getString("address"));
                b.setContact(rs.getString("contact"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                conn.close(); //very important
            } catch (SQLException ex1) {
                return null;
            }
        }

        return b;
    }

    public static ArrayList<AuctionProduct> getAuctionDetails() {
        boolean result = false;
        ArrayList<AuctionProduct> details = new ArrayList<AuctionProduct>();
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM auctionresult";

        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(selectSQL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AuctionProduct info = new AuctionProduct();

                int auctionId = rs.getInt("auctionId");
                int productId = rs.getInt("pdId");

                String auctionSQL = "SELECT * FROM auction where auctionId=" + auctionId;
                PreparedStatement auctionStmt = null;
                auctionStmt = conn.prepareStatement(auctionSQL);
                ResultSet auctionRs = auctionStmt.executeQuery();
                if (auctionRs.next()) {
                    info.setAuctionType(auctionRs.getString("type"));
                    info.setAuctionDate(auctionRs.getDate("date"));
                }

                String productSQL = "SELECT * FROM products where pdId=" + productId;
                PreparedStatement productStmt = null;
                productStmt = conn.prepareStatement(productSQL);
                ResultSet productRs = productStmt.executeQuery();
                if (productRs.next()) {
                    info.setProductName(productRs.getString("pdName"));
                }

                info.setAuctionId(auctionId);
                info.setProductId(productId);
                details.add(info);

            }

        } catch (SQLException ex) {
            Logger.getLogger(BidderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return details;
    }

    public static Bid getBidInfo(int auctionId, int productId) throws SQLException {
        boolean result = false;

        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM bid where auctionId=? and pdId=?";

        PreparedStatement stmt = null;
        Bid bid = new Bid();
        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setInt(1, auctionId);
            stmt.setInt(2, productId);
            int max = 0;
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                bid.setAuctionId(rs.getInt("auctionID"));
                bid.setBidId(rs.getInt("bidId"));
                bid.setPdId(rs.getInt("pdId"));
                bid.setBiddersId(rs.getInt("biddersId"));
                if (max < rs.getInt("bidPrice")) {
                    max = rs.getInt("bidPrice");
                }
            }
            bid.setMaxPrice(max);
            max = 0;
            selectSQL = "SELECT * FROM inventory where pdId=" + productId;
            stmt = conn.prepareStatement(selectSQL);
            rs = stmt.executeQuery();
            while (rs.next()) {

                max = rs.getInt("basePrice");
            }
            bid.setBasePrice(max);

        } catch (SQLException ex) {
            Logger.getLogger(BidderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bid;
    }

    public static Bid updateBid(int biddersId, int auctionId, int productId, double bidPrice) throws SQLException {
        boolean result = false;

        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "insert into bid (biddersId, pdId, auctionId, bidPrice) values( ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        Bid bid = new Bid();
        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setInt(1, biddersId);
            stmt.setInt(2, productId);
            stmt.setInt(3, auctionId);
            stmt.setDouble(4, bidPrice);
            int max = 0;
            int row = stmt.executeUpdate();

            bid = getBidInfo(auctionId, productId);

        } catch (SQLException ex) {
            Logger.getLogger(BidderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bid;
    }

    public static ArrayList<Role> getRole() {

        //Role rol=new Role();
        ArrayList<Role> roleList = new ArrayList<>();
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM roletable";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(selectSQL);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Role rol = new Role();
                rol.setRoleId(rs.getInt("roleId"));
                rol.setRoleName(rs.getString("roleName"));
                roleList.add(rol);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BidderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return roleList;

    }

    public static boolean updateBidderInfo(Bidders bd) {
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        boolean result = true;

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String insertSQL = "UPDATE bidders set name=?, username=?, contact=?, address=? where bidderId=?";

        PreparedStatement stmt = null; //will explain later
        int row = 0;

        if (conn == null) {
            return false;
        }

        try {
            stmt = conn.prepareStatement(insertSQL);

            //
            stmt.setString(1, bd.getName());
            stmt.setString(2, bd.getUsername());
            stmt.setString(3, bd.getContact());
            stmt.setString(4, bd.getAddress());
            stmt.setInt(5, bd.getId());
            //stmt.setInt(9, emp.getStatus());

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

    public static ArrayList showBidderInfo(int bidderId) {

        ArrayList bidderList = new ArrayList();

        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();
        
        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM bidders where bidderId="+bidderId;

        PreparedStatement stmt = null; //will explain later

        try {
            stmt = conn.prepareStatement(selectSQL);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Bidders bd = new Bidders();

                bd.setId(rs.getInt("bidderId"));
                bd.setName(rs.getString("name"));
                bd.setUsername(rs.getString("username"));
                bd.setContact(rs.getString("contact"));        
                bd.setAddress(rs.getString("address"));
                bd.setStatus(rs.getInt("status"));
                bidderList.add(bd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                conn.close(); //very important
            } catch (SQLException ex1) {
                return null;
            }
        }

        return bidderList;

    }

}
