/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dto;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tc.dao.BidderDao;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author kishlay.verma
 */
public class Bidders extends ActionSupport {

    private int id;
    private int roleId;
    private String name;
    private String address;
    private String contact;
    private String username;
    private String password;
    private int status;
    private boolean isLoggedIn;
    private Map<String, Object> session;
    private ArrayList<Bidders> list = new ArrayList<>();
    private ArrayList<Role> roleList = new ArrayList<Role>();
    private ArrayList<String> roleNameList = new ArrayList<String>();
    private String checkRoleName;

    public Bidders loginBidders(String username, String password) {
        String res = "failure";
        Bidders bidder = new Bidders();
        boolean output = BidderDao.validateBidders(username, password);
        if (output == true) {
            res = "success";
            bidder = BidderDao.getBidder(username, password);
            this.setId(bidder.getId());
            this.setName(bidder.getName());
            this.setUsername(bidder.getUsername());
            this.setPassword(bidder.getPassword());
            this.setRoleId(bidder.getRoleId());
            this.setStatus(bidder.getStatus());
            this.setAddress(bidder.getAddress());
            this.setContact(bidder.getContact());
            this.setIsLoggedIn(true);
            setSession(ActionContext.getContext().getSession());
            getSession().put("bidder", bidder);
        }
        return bidder;
    }

    public Bidders() {

    }

    public Bidders(Bidders b) {
        //id=b.id;
        //roleId=b.roleId;
        setName(b.getName());
        setAddress(b.getAddress());
        setContact(b.getContact());
        setUsername(b.getUsername());
        setStatus(b.getStatus());
        setId(b.getId());
        setIsLoggedIn(true);
    }

//    public String loginBidders(String username, String password){
//        String res="failure";
//        //System.out.println("milan is the ");
//        boolean output=BidderDao.validateBidders(this.username, this.password);
//        if(output==true){
//            res="success";
//            Bidders bidder=BidderDao.getBidder(this.username, this.password);
//            this.setId(bidder.getId());
//            this.setName(bidder.getName());
//            this.setUsername(bidder.getUsername());
//            this.setPassword(bidder.getPassword());
//            this.setRoleId(bidder.getRoleId());
//            this.setStatus(bidder.getStatus());
//            this.setAddress(bidder.getAddress());
//            this.setContact(bidder.getContact());
//            this.setIsLoggedIn(true);
//            setSession(ActionContext.getContext().getSession());
//            getSession().put("user", bidder);
//        }
//        
//        return res;
//    }
    public String biddersInfo() {
        String res = "failure";
        session = ActionContext.getContext().getSession();
        if (session.containsKey("user")) {
            Bidders bidder = new Bidders();
            this.setId(bidder.getId());
            this.setName(bidder.getName());
            this.setUsername(bidder.getUsername());
            this.setPassword(bidder.getPassword());
            this.setRoleId(bidder.getRoleId());
            this.setStatus(bidder.getStatus());
            this.setAddress(bidder.getAddress());
            this.setContact(bidder.getContact());
            res = "success";
        }
        return res;
    }

    public String updateBidder() {

        String forward = "failure";
        //this.setId(this.id);
        this.setName(this.name);
        this.setUsername(this.username);
        this.setContact(this.contact);
        this.setAddress(this.address);
        //System.out.println(this.name);
        boolean result = BidderDao.updateBidderInfo(this);

        if (result) {
            setList((ArrayList<Bidders>) BidderDao.showBidderInfo(this.id));
            forward = "success";
            Bidders b = new Bidders(list.get(0));
            setSession(ActionContext.getContext().getSession());
            getSession().put("user", b);
        }
        return forward;
    }

    public String getBidder() {

        String forward = "failure";
        String bidderId = String.valueOf(this.getId());
        Bidders bidder = BidderDao.getBidderInfo(bidderId);
        this.setId(bidder.getId());
        this.setName(bidder.getName());
        this.setUsername(bidder.getUsername());
        this.setContact(bidder.getContact());
        this.setAddress(bidder.getAddress());
        if (bidder != null) {
            forward = "success";
        }
        return forward;
    }

    public String logOff() {

        String forward = "failure";
        //String empName = String.valueOf(this.getEmployeeName());
        session = ActionContext.getContext().getSession();
        if (session == null) {
            forward = "success";
        } else if (session.containsKey("bidder")) {
            session.remove("bidder");
            forward = "success";
        }

        return forward;
    }

    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    public String roleFunction() {
        String forward = "failure";
        setRoleList((ArrayList<Role>) BidderDao.getRole());
        forward = "success";
        return forward;
    }

    /**
     * @return the roleList
     */
    public ArrayList<Role> getRoleList() {
        return roleList;
    }

    /**
     * @param roleList the roleList to set
     */
    public void setRoleList(ArrayList<Role> roleList) {
        this.roleList = roleList;
    }

    public void setList(ArrayList<Bidders> list) {
        this.list = list;
    }

}
