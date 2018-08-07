/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dto;

import java.util.Date;

/**
 *
 * @author meghna.dan
 */
public class AdminObject {
     private int auctionid;
    private Date date;
    private int suppId;
    private String SuppName;
    private String orgName;
    private int productId;
    private String productName;
    private int bidId;
    private double price;
    private int bidderId;

    /**
     * @return the auctionid
     */
    public int getAuctionid() {
        return auctionid;
    }

    /**
     * @param auctionid the auctionid to set
     */
    public void setAuctionid(int auctionid) {
        this.auctionid = auctionid;
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
     * @return the SuppName
     */
    public String getSuppName() {
        return SuppName;
    }

    /**
     * @param SuppName the SuppName to set
     */
    public void setSuppName(String SuppName) {
        this.SuppName = SuppName;
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
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the bidId
     */
    public int getBidId() {
        return bidId;
    }

    /**
     * @param bidId the bidId to set
     */
    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the bidderId
     */
    public int getBidderId() {
        return bidderId;
    }

    /**
     * @param bidderId the bidderId to set
     */
    public void setBidderId(int bidderId) {
        this.bidderId = bidderId;
    }
}
