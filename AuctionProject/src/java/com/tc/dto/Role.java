/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dto;

import com.tc.dao.RoleDao;
import java.util.ArrayList;

/**
 *
 * @author sourav.mondal
 */
public class Role {

    private int roleId;
    private String roleName;
    private ArrayList<Role> roleList = new ArrayList<Role>();
    private ArrayList<String> roleNameList = new ArrayList<String>();

    public Role() {
    }

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
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String roleFunction() {
        String forward = "failure";
        setRoleList((ArrayList<Role>) RoleDao.getRole());
        setRoleNameList((ArrayList<String>) RoleDao.getRoleName());
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

    /**
     * @return the roleNameList
     */
    public ArrayList<String> getRoleNameList() {
        return roleNameList;
    }

    /**
     * @param roleNameList the roleNameList to set
     */
    public void setRoleNameList(ArrayList<String> roleNameList) {
        this.roleNameList = roleNameList;
    }

}
