package com.tc.dto;

import com.opensymphony.xwork2.ActionContext;
import com.tc.dao.AuctionControllerDao;
import com.tc.dao.BidderDao;
import com.tc.dao.SupplierDao;
import com.tc.helpers.DatabseConnectionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * @author ajay.sharma
 */
public class AuctionController {

    private int acId;
    private String acName;
    private int roleId;
    private String bu;
    private String username;
    private String password;
    private int auctionId;
    private int suppId;
    private boolean isLoggedIn;
    private Map<String, Object> session;
    private ArrayList<Suppliers> supplier;
    private ArrayList<Products> productList;
    private ArrayList<Auction> auctionList;
    private ArrayList<Bidders> bidderList;
    private HashMap<Integer, ArrayList<AdminObject>> adminMap;
     private ArrayList<ProductInfo> productInfo=new ArrayList<ProductInfo>();
    private ArrayList<String> aclist = new ArrayList<>();
    private ArrayList<Suppliers> suppliersList = new ArrayList<Suppliers>();
    private ArrayList<AdminObject> adminObjectList = new ArrayList<AdminObject>();
   
    public String showAllAuctions() throws SQLException {
        String res = "success";
        ArrayList<Auction> auctionList = new ArrayList<Auction>();
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        String selectSQL = "SELECT * FROM auction";
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement(selectSQL);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Auction auction = new Auction();
            int auctionId = rs.getInt("auctionId");
            String type = rs.getString("type");
            Date date = rs.getDate("date");
            int suppId = rs.getInt("suppId");
            int status = rs.getInt("status");
            auction.setAuctionId(auctionId);
            auction.setDate(date);
            auction.setStatus(status);
            auction.setSuppId(suppId);
            auction.setType(type);
            auctionList.add(auction);

        }

        this.setAuctionList(auctionList);

        return res;
    }

    public String getProductListOne() throws SQLException {
        String res = "failure";
        ArrayList<ProductInfo> productInfoList = new ArrayList<ProductInfo>();
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        int suppId = this.getSuppId();
        this.setAuctionId(getAuctionId());
        String selectProductIdSQL = "SELECT distinct pId FROM bid where auctionId=" + getAuctionId();

        PreparedStatement stmProduct = null;
        stmProduct = conn.prepareStatement(selectProductIdSQL);
        ResultSet rs = stmProduct.executeQuery();
        while (rs.next()) {
            int pid = rs.getInt("pdId");
            String selectProductSQL = "SELECT *FROM products"
                                      + " LEFT JOIN inventory" 
                                      +" ON products.pdId = inventory.pdId";
                                     
        
        PreparedStatement stmP = null;
            stmP = conn.prepareStatement(selectProductSQL);
            ResultSet rspd = stmP.executeQuery(selectProductSQL);
            ProductInfo pdInfo = new ProductInfo();
            if (rspd.next()) {
                String pdName=rs.getString("pdName");
                 suppId=rs.getInt("suppId");
                int id=rs.getInt("id");
                double quantity=rs.getDouble("quantity");
                double basePrice=rs.getDouble("basePrice");
                pdInfo.setBasePrice(basePrice);
                pdInfo.setId(id);
                pdInfo.setQuantity(quantity);
                pdInfo.setPdId(pid);
                pdInfo.setPdName(pdName);
                pdInfo.setSuppId(suppId);
                productInfoList.add(pdInfo);
                
            }
            this.setProductInfo(productInfoList);
        }

        return res;
    }

    public String getSupplierInfo() throws SQLException {
        String res = "failure";
        ArrayList<Suppliers> suppList = new ArrayList<Suppliers>();
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        this.setAuctionId(getAuctionId());
        String selectSQL = "SELECT suppId FROM auction where auctionId=" + getAuctionId();

        PreparedStatement stmt = null;
        stmt = conn.prepareStatement(selectSQL);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            setSuppId(rs.getInt("suppId"));
        }

        String selectSupplierSQL = "SELECT * FROM suppliers where auctionId=" + getAuctionId();
        PreparedStatement stmtSupplier = null;
        stmtSupplier = conn.prepareStatement(selectSupplierSQL);
        ResultSet rsSupplier = stmtSupplier.executeQuery();
        Suppliers supp = new Suppliers();
        if (rsSupplier.next()) {
            String suppName = rs.getString("suppName");
            String orgName = rs.getString("orgName");
            int roleId = rs.getInt("roleId");
            int status = rs.getInt("status");
            supp.setSuppId(getSuppId());
            supp.setSuppName(suppName);
            supp.setRoleId(roleId);
            supp.setOrgName(orgName);
            supp.setStatus(status);
            suppList.add(supp);
        }
        this.setSuppliersList(suppList);
        return res;
    }
    private ArrayList<Bidders> al = new ArrayList<Bidders>();
    
    
    
    public String showAllBiddersData() throws SQLException {
        String res = "failure";
        ArrayList<Suppliers> suppList = new ArrayList<Suppliers>();
        DatabseConnectionClass databseConnectionClass = DatabseConnectionClass.getInstance();

        Connection conn = databseConnectionClass.getMySqlConnection("jdbc:mysql://localhost:3306/", "auctionsystem", "app_user", "qwerty", "com.mysql.jdbc.Driver");

        //Step 2. Now Use PreparedStatement class to pass SQL to create employee
        this.setAuctionId(getAuctionId());
        String selectBidderSQL = "SELECT distinct bidderId FROM bid where auctionId=" + getAuctionId();

        PreparedStatement stmtBidder = null;
        stmtBidder = conn.prepareStatement(selectBidderSQL);
        ResultSet rs = stmtBidder.executeQuery();

        return res;
    }

    /**
     * @return the adminMap
     */
    public Map<Integer, ArrayList<AdminObject>> getAdminMap() {
        return adminMap;
    }

    /**
     * @param adminMap the adminMap to set
     */
    public void setAdminMap(HashMap<Integer, ArrayList<AdminObject>> adminMap) {
        this.adminMap = adminMap;
    }

    /**
     * @return the supplier
     */
    public ArrayList<Suppliers> getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(ArrayList<Suppliers> supplier) {
        this.supplier = supplier;
    }

    /**
     * @return the productList
     */
//    public ArrayList<Products> getProductList() {
//        return productList;
//    }
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
     * @return the aclist
     */
    public ArrayList<String> getAclist() {
        return aclist;
    }

    /**
     * @param aclist the aclist to set
     */
    public void setAclist(ArrayList<String> aclist) {
        this.aclist = aclist;
    }

    /**
     * @return the suppliersList
     */
    public ArrayList<Suppliers> getSuppliersList() {
        return suppliersList;
    }

    /**
     * @param suppliersList the suppliersList to set
     */
    public void setSuppliersList(ArrayList<Suppliers> suppliersList) {
        this.suppliersList = suppliersList;
    }

    /**
     * @return the adminObjectList
     */
    public ArrayList<AdminObject> getAdminObjectList() {
        return adminObjectList;
    }

    /**
     * @param adminObjectList the adminObjectList to set
     */
    public void setAdminObjectList(ArrayList<AdminObject> adminObjectList) {
        this.adminObjectList = adminObjectList;
    }

    /**
     * @return the productInfo
     */
    public ArrayList<ProductInfo> getProductInfo() {
        return productInfo;
    }

    /**
     * @param productInfo the productInfo to set
     */
    public void setProductInfo(ArrayList<ProductInfo> productInfo) {
        this.productInfo = productInfo;
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

    /**
     * @return the al
     */
    public ArrayList<Bidders> getAl() {
        return al;
    }

    /**
     * @param al the al to set
     */
    public void setAl(ArrayList<Bidders> al) {
        this.al = al;
    }

    /**
     * @return the productList
     */
    public ArrayList<Products> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(ArrayList<Products> productList) {
        this.productList = productList;
    }

    /**
     * @return the auctionList
     */
    public ArrayList<Auction> getAuctionList() {
        return auctionList;
    }

    /**
     * @param auctionList the auctionList to set
     */
    public void setAuctionList(ArrayList<Auction> auctionList) {
        this.auctionList = auctionList;
    }

    /**
     * @return the bidderList
     */
    public ArrayList<Bidders> getBidderList() {
        return bidderList;
    }

    /**
     * @param bidderList the bidderList to set
     */
    public void setBidderList(ArrayList<Bidders> bidderList) {
        this.bidderList = bidderList;
    }
}

