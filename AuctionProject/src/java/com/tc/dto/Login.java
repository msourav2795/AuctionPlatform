/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dto;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Milan.Mukherjee
 */
public class Login extends ActionSupport {

    private Bidders tempBidder;
    private Suppliers tempSupplier;
    private Admin tempAdmin;
    private String username;
    private String password;
    private String checkRoleName;

    public String loginCheck() {

        String res = "failure";
        System.out.println("in Logincheck"+ this.checkRoleName);
        if (this.checkRoleName.equals("Bidders")) {
            System.out.println("in Login" + this.checkRoleName);
            Bidders temp = new Bidders();
            temp = temp.loginBidders(this.getUsername(), this.getPassword());
            //  System.out.println(temp.getId() + "tempbidder");
            if (temp.getId() != 0) {
                setTempBidder(temp);
                res = "Bidder";
            }
        } else if (this.checkRoleName.equals("Supplier")) {
            //  System.out.println("in Login"+this.checkRoleName);
            Suppliers temp = new Suppliers();
            System.out.println(this.getUsername() + this.getPassword() + "in login.java");
            temp = temp.loginSuppliers(this.getUsername(), this.getPassword());
            // System.out.println(temp.getSuppId() + "tempsupplier");
            if (temp.getSuppId() != 0) {
                setTempSupplier(temp);
                System.out.println(temp.getSuppId());
                res = "Supplier";
            }
        }
        else if(this.checkRoleName.equals("Admin")) {
            System.out.println("in Login" + this.checkRoleName);
            Admin temp = new Admin();
            temp = temp.loginAdmin(this.getUsername(), this.getPassword());
            //  System.out.println(temp.getId() + "tempbidder");
            if (temp.getAcId() != 0) {
                setTempAdmin(temp);
                res = "Admin";
            }
        }
        return res;
    }

    /**
     * @return the tempBidder
     */
    public Bidders getTempBidder() {
        return tempBidder;
    }

    /**
     * @param tempBidder the tempBidder to set
     */
    public void setTempBidder(Bidders tempBidder) {
        this.tempBidder = tempBidder;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the checkRoleName
     */
    public String getCheckRoleName() {
        return checkRoleName;
    }

    /**
     * @param checkRoleName the checkRoleName to set
     */
    public void setCheckRoleName(String checkRoleName) {
        this.checkRoleName = checkRoleName;
    }

    /**
     * @return the tempSupplier
     */
    public Suppliers getTempSupplier() {
        return tempSupplier;
    }

    /**
     * @param tempSupplier the tempSupplier to set
     */
    public void setTempSupplier(Suppliers tempSupplier) {
        this.tempSupplier = tempSupplier;
    }

    /**
     * @return the tempAdmin
     */
    public Admin getTempAdmin() {
        return tempAdmin;
    }

    /**
     * @param tempAdmin the tempAdmin to set
     */
    public void setTempAdmin(AuctionController tempAdmin) {
        this.setTempAdmin(tempAdmin);
    }

    /**
     * @param tempAdmin the tempAdmin to set
     */
    public void setTempAdmin(Admin tempAdmin) {
        this.tempAdmin = tempAdmin;
    }

}
