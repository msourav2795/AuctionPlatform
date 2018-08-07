/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dto;

import com.tc.dao.BidderDao;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author msour
 */
public class AuctionProduct{

    private String auctionType;
    private String supplierName;
    private String productName;
    private Date auctionDate;
    private int auctionId;
    private int productId;
    private Bid bid;
    private int biddersIdTemp;
    private String biddersPriceTemp;
      
     public String getFullAuctionDetails() throws SQLException{
        String res="failure";
        
         //setAuctionDate(this.auctionDate);
         setAuctionId(this.auctionId);
         setAuctionType(this.auctionType);
         setProductId(this.productId);
         setProductName(this.productName);
         Bid output=BidderDao.getBidInfo(this.auctionId, this.productId);
        if(output!=null){
            setBid(output);
            res="success";
        }
        
        return res;
    }
     
     public String setBids() throws SQLException{
        String res="failure";
        System.out.println("Hello world1");
       
         //setAuctionDate(this.auctionDate);
         setAuctionId(this.auctionId);
         setAuctionType(this.auctionType);
         setProductId(this.productId);
         setProductName(this.productName);
         System.out.println("Hello world3");
         Bid newBid=this.bid;
         System.out.println();
         int biddersId=this.getBiddersIdTemp();
         System.out.println("Hello world6");
         int auctionId=this.auctionId;
         int productId=this.productId;
         System.out.println("Hello worldegesgb");
          System.out.println(this.getBiddersPriceTemp());
         double bidPrice=Double.parseDouble(this.biddersPriceTemp);
         System.out.println("Hello world7");
         //Bid output=BidderDao.getBidInfo(this.auctionId, this.productId);
         Bid output=BidderDao.updateBid(biddersId, auctionId, productId, bidPrice);
        if(output!=null){
            
             System.out.println("Hello world8");
            setBid(output);
            res="success";
        }
        
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
     * @return the auctionType
     */
    public String getAuctionType() {
        return auctionType;
    }

    /**
     * @param auctionType the auctionType to set
     */
    public void setAuctionType(String auctionType) {
        this.auctionType = auctionType;
    }

    /**
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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
     * @return the auctionDate
     */
    public Date getAuctionDate() {
        return auctionDate;
    }

    /**
     * @param auctionDate the auctionDate to set
     */
    public void setAuctionDate(Date auctionDate) {
        this.auctionDate = auctionDate;
    }

    /**
     * @return the bid
     */
    public Bid getBid() {
        return bid;
    }

    /**
     * @param bid the bid to set
     */
    public void setBid(Bid bid) {
        this.bid = bid;
    }

    /**
     * @return the biddersIdTemp
     */
    public int getBiddersIdTemp() {
        return biddersIdTemp;
    }

    /**
     * @param biddersIdTemp the biddersIdTemp to set
     */
    public void setBiddersIdTemp(int biddersIdTemp) {
        this.biddersIdTemp = biddersIdTemp;
    }

    /**
     * @return the biddersPriceTemp
     */
    public String getBiddersPriceTemp() {
        return biddersPriceTemp;
    }

    /**
     * @param biddersPriceTemp the biddersPriceTemp to set
     */
    public void setBiddersPriceTemp(String biddersPriceTemp) {
        this.biddersPriceTemp = biddersPriceTemp;
    }
    }
