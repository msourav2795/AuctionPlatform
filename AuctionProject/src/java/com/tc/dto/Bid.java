/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dto;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author msour
 */
public class Bid extends ActionSupport{

    /**
     * @return the maxPrice
     */
    public int getMaxPrice() {
        return maxPrice;
    }

    /**
     * @param maxPrice the maxPrice to set
     */
    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * @return the basePrice
     */
    public int getBasePrice() {
        return basePrice;
    }

    /**
     * @param basePrice the basePrice to set
     */
    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * @return the max
     */
   

    /**
     * @return the auctionData
     */
    
    private double bidPrice;
    private int biddersId;
    private int pdId;
    private int auctionId;
    private int bidId;
    private int maxPrice;
    private int basePrice;
    
    
   
    /**
     * @return the bidPrice
     */
    public double getBidPrice() {
        return bidPrice;
    }

    /**
     * @param bidPrice the bidPrice to set
     */
    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    /**
     * @return the bidderId
     */
    public int getBiddersId() {
        return biddersId;
    }

    /**
     * @param bidderId the bidderId to set
     */
    public void setBiddersId(int bidderId) {
        this.biddersId = bidderId;
    }

    /**
     * @return the pdId
     */
    public int getPdId() {
        return pdId;
    }

    /**
     * @param pdId the pdId to set
     */
    public void setPdId(int pdId) {
        this.pdId = pdId;
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
}
