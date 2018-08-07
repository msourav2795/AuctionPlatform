
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dto;

/**
 *
 * @author ajay.sharma
 */
public class ProductInfo {
    
     private int pdId;
     private String pdName;
     private int suppId;
     private int id;
     private double quantity;
     private double basePrice;

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
     * @return the pdName
     */
    public String getPdName() {
        return pdName;
    }

    /**
     * @param pdName the pdName to set
     */
    public void setPdName(String pdName) {
        this.pdName = pdName;
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
     * @return the id
     */
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
     * @return the quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the basePrice
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * @param basePrice the basePrice to set
     */
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
        
    
}