/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dto;

import com.opensymphony.xwork2.ActionSupport;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.tc.dao.AuctionDao;
import com.tc.dao.BidderDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
public class Auction extends ActionSupport{
    private int auctionId;
    private int suppId;
    private int status;
    private String type;
    private Date date;
    private ArrayList<Products> products;
    
    
    private ArrayList<AuctionProduct> auctionData;
    
    
    public String getAuctionDetails(){
        String res="failure";
        ArrayList<AuctionProduct> data=BidderDao.getAuctionDetails();
        if(data!=null){
            setAuctionData(data);
            res="success";
        }
        return res;
    }
    
    public String getProductByAuction() throws SQLException{
        String res="success";
        int auctionId=this.auctionId;
        System.out.println("Entered");
        setProducts(AuctionDao.getProducts(auctionId));
        System.out.println("Entered");
        return res;
    }
    /**
     * @return the auctionId
     */
    public int getAuctionId() {
        return auctionId;
    }

    /**
     * @param auctionId the auctionId to set
     */
    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the auctionData
     */
    public ArrayList<AuctionProduct> getAuctionData() {
        return auctionData;
    }

    /**
     * @param auctionData the auctionData to set
     */
    public void setAuctionData(ArrayList<AuctionProduct> auctionData) {
        this.auctionData = auctionData;
    }

    /**
     * @return the products
     */
    public ArrayList<Products> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    /**
     * @return the products
     */
   
}

