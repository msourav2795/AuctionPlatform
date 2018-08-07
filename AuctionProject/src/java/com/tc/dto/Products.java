/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dto;

/**
 *
 * @author msour
 */
public class Products {
    private int pdId;
    private int suppId;
    private String pdName;
    private Inventory inventory;

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
     * @return the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * @param inventory the inventory to set
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
}

