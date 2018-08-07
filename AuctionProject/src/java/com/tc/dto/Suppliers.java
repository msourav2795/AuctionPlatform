/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dto;

import com.opensymphony.xwork2.ActionContext;
import com.tc.dao.SupplierDao;
import java.util.Map;

/**
 *
 * @author Saif.Ali
 */
public class Suppliers {

    private int suppId;
    private String suppName;
    private String orgName;
    private int roleId;
    private int status;
    private String username;
    private String password;
    private boolean isLoggedIn;
    private Map<String, Object> session;

    public Suppliers loginSuppliers(String username, String password) {
        String res = "failure";
        Suppliers supplier = new Suppliers();
        //   System.out.println(this.username+ this.password+"in supplier.java");
        boolean output = SupplierDao.validateSupplier(username, password);
        System.out.println("abcdef in supplier login check  " + output);
        if (output == true) {
            res = "success";
            supplier = SupplierDao.getSupplier(username, password);
            this.setSuppId(supplier.getSuppId());
            this.setSuppName(supplier.getSuppName());
            this.setUsername(supplier.getUsername());
            this.setPassword(supplier.getPassword());
            this.setRoleId(supplier.getRoleId());
            this.setStatus(supplier.getStatus());
            //this.setAddress(supplier.getAddress());
            this.setOrgName(supplier.getOrgName());
            this.setIsLoggedIn(true);
            setSession(ActionContext.getContext().getSession());
            getSession().put("supplier", supplier);
            //System.out.println("abcdef in supplier login check inside output  " + supplier.getSuppName());
        }
        // System.out.println("abcdef in supplier login check  "+this.getSuppName());
        return supplier;
    }
    
    public String logOff() {

        String forward = "failure";
        //String empName = String.valueOf(this.getEmployeeName());
        session = ActionContext.getContext().getSession();
        if (session == null) {
            forward = "success";
        } else if (session.containsKey("supplier")) {
            session.remove("supplier");
            forward = "success";
        }

        return forward;
    }

    /**
     * @return the suppId
     */
    public int getSuppId() {
        return suppId;
    }

    /**
     * @param suppId the suppId to set
     */
    public void setSuppId(int suppId) {
        this.suppId = suppId;
    }

    /**
     * @return the suppName
     */
    public String getSuppName() {
        return suppName;
    }

    /**
     * @param suppName the suppName to set
     */
    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    /**
     * @return the orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName the orgName to set
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return the roleId
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
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
     * @return the isLoggedIn
     */
    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    /**
     * @param isLoggedIn the isLoggedIn to set
     */
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    private Map<String, Object> getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
