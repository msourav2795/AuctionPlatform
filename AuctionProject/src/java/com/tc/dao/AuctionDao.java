/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dao;

import com.tc.dto.Auction;
import com.tc.dto.Inventory;
import com.tc.dto.Products;
import com.tc.helpers.DatabseConnectionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sourav.mondal
 */
public class AuctionDao {
    public static ArrayList<Products> getProducts(int auctionId) throws SQLException{
        ArrayList<Products> productList = new ArrayList<Products>();
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM products where auctionId="+auctionId;
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement(selectSQL);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Products product = new Products();
            int pdId = rs.getInt("pdId");
            String pdName = rs.getString("pdName");
            int suppId = rs.getInt("suppId");
            product.setPdId(pdId);
            product.setPdName(pdName);
            product.setSuppId(suppId);
            
            selectSQL = "SELECT * FROM inventory where pdId="+pdId;
            stmt = null;
            stmt = conn.prepareStatement(selectSQL);
            rs = stmt.executeQuery();
            Inventory inventory=new Inventory();
            while(rs.next()){
                int id=rs.getInt("id");
                double quantity=rs.getDouble("quantity");
                double basePrice=rs.getDouble("basePrice");
                inventory.setId(id);
                inventory.setQuantity(quantity);
                inventory.setBasePrice(basePrice);
            }
            product.setInventory(inventory);
            productList.add(product);

        }
        return productList;
    }
}
