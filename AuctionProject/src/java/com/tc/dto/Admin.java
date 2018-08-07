/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dto;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tc.dao.AdminDao;
import com.tc.dao.BidderDao;
import java.util.Map;

/**
 *
 * @author sourav.mondal
 */
public class Admin extends ActionSupport{
    private int acId;
    private String acName;
    private int roleId;
    private String bu;
    private String username;
    private String password;
    private boolean isLoggedIn;
    private Map<String, Object> session;
    
    public Admin loginAdmin(String username, String password) {
        String res = "failure";
        Admin admin = new Admin();
        boolean output = AdminDao.validateAdmin(username, password);
        if (output == true) {
            res = "success";
            admin = AdminDao.getAdmin(username, password);
            this.setAcId(admin.getAcId());
            this.setAcName(admin.getAcName());
            this.setUsername(admin.getUsername());
            this.setPassword(admin.getPassword());
            this.setRoleId(admin.getRoleId());
            this.setBu(admin.getBu());
            this.setIsLoggedIn(true);
            setSession(ActionContext.getContext().getSession());
            getSession().put("admin", admin);
        }
        return admin;
    }
    public String logOff() {

        String forward = "failure";
        //String empName = String.valueOf(this.getEmployeeName());
        setSession(ActionContext.getContext().getSession());
        if (getSession() == null) {
            forward = "success";
        } else if (getSession().containsKey("admin")) {
            getSession().remove("admin");
            forward = "success";
        }

        return forward;
    }
    
    

    /**
     * @return the acId
     */
    public int getAcId() {
        return acId;
    }

    /**
     * @param acId the acId to set
     */
    public void setAcId(int acId) {
        this.acId = acId;
    }

    /**
     * @return the acName
     */
    public String getAcName() {
        return acName;
    }

    /**
     * @param acName the acName to set
     */
    public void setAcName(String acName) {
        this.acName = acName;
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
     * @return the bu
     */
    public String getBu() {
        return bu;
    }

    /**
     * @param bu the bu to set
     */
    public void setBu(String bu) {
        this.bu = bu;
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
    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    /**
     * @param isLoggedIn the isLoggedIn to set
     */
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    /**
     * @return the session
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
