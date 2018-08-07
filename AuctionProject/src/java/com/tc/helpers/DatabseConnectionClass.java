/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tc.helpers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author techcluster001
 */
public class DatabseConnectionClass {

    private static DatabseConnectionClass dbConnection = null; //this is a class variable and will be 
    //shared between all objects of this class at runtime. 
    Connection conn = null;
    String url;
    String dbName;
    String userName;
    String password;

    String driver;

    private DatabseConnectionClass() {
    }

    public static DatabseConnectionClass getInstance() {
        if (dbConnection == null) {
            dbConnection = new DatabseConnectionClass();
        }
        return dbConnection;
    }

    public Connection getMySqlConnection(String url, String dbName, String userName, String password, String driver) {
        try {
            Class.forName(driver).newInstance();//this will provide an instance of DriverManager
            conn = DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;

    }
}

