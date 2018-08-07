/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dao;

import com.tc.dto.Admin;
import com.tc.dto.Bidders;
import com.tc.helpers.DatabseConnectionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sourav.mondal
 */
public class AdminDao {
    public static boolean validateAdmin(String username, String password) {
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
    
    public static Admin getAdmin(String username, String password) {
        boolean result = false;

        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM auctioncontroller where username=? and password=?";

        PreparedStatement stmt = null;
        Admin b = new Admin();
        try {
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                b.setAcId(rs.getInt("acId"));
                b.setAcName(rs.getString("acName"));
                b.setRoleId(rs.getInt("roleId"));
                b.setUsername(rs.getString("username"));
                b.setPassword(rs.getString("password"));
                b.setBu(rs.getString("bu"));
                b.setIsLoggedIn(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BidderDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }
}
