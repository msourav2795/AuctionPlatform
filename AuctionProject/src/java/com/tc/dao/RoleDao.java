/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dao;

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
 * @author Milan.Mukherjee
 */
public class RoleDao {
    
      public static ArrayList<Role> getRole() {
        
        //Role rol=new Role();
        ArrayList<Role> roleList=new ArrayList<>();
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM roletable";

        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(selectSQL);

            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Role rol=new Role();
                rol.setRoleId(rs.getInt("roleId"));
                rol.setRoleName(rs.getString("roleName"));
                roleList.add(rol);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BidderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return roleList;
        
        
    }
      
      
      
      public static ArrayList<String> getRoleName() {
        
        //Role rol=new Role();
        ArrayList<String> roleList=new ArrayList<>();
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM roletable";

        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(selectSQL);

            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
               
                roleList.add(rs.getString("roleName"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BidderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return roleList;
        
        
    }
     
}
