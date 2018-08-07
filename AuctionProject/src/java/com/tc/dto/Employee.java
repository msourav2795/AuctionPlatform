/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dto;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tc.dao.EmployeeDao;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.ws.spi.http.HttpContext;



/**
 *
 * @author techcluster001
 */
public class Employee extends ActionSupport{

    /**
     * @return the email
     */
    

    private int employeeId;
    private String firstName;
    private String lastName;
    private String middleName;
    private double salary;
    private String designation;
    private String team;
    private String contact;
    private int status;
    
    
    
    
    
    
    private String email;
    private String password;
    private String username;
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
    
    
    
    
    
    
    private static final String organizationName="Mjunction";
    
    private ArrayList<Employee> list=new ArrayList<>();
    
    private Map<String, Object> session;
    
    private ArrayList<Role> roleList=new ArrayList<Role>();

    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the team
     */
    public String getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(String team) {
        this.team = team;
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
     * @return the organizationName
     */
    public static String getOrganizationName() {
        return organizationName;
    }

    public String saveEmployee() {

        String forward = "failure";
        //session = ActionContext.getContext().getSession();
        boolean result = EmployeeDao.saveEmployeeInfo(this);
        if (result) {
            
            //session.put("trackerId", "1111");
            setList((ArrayList<Employee>) EmployeeDao.showAllEmployeeInfo());
            forward = "success";
        }
        else
        {
            addActionError("Could Not Create Employee");
        }
        return forward;
    }
    public String getEmployee() {

        String forward = "failure";
//        session = ActionContext.getContext().getSession();
//        
//        if(!session.get("trackerId").equals("1111"))
//            return "nosession";       
        
        String empId = String.valueOf(this.getEmployeeId());
        Employee emp = EmployeeDao.getEmployeeInfo(empId);
        this.setEmployeeId(emp.getEmployeeId());
        this.setFirstName(emp.getFirstName());
        this.setMiddleName(emp.getMiddleName());
        this.setLastName(emp.getLastName());
        this.setDesignation(emp.getDesignation());
        this.setTeam(emp.getTeam());
        this.setContact(emp.getContact());       
        this.setSalary(emp.getSalary());
        this.setStatus(emp.getStatus());
        

        if (emp != null) {            
            forward = "success";
        }
        return forward;
    }
    
    public String updateEmployee() {

        String forward = "failure";
        boolean result = EmployeeDao.updateEmployeeInfo(this);
        if (result) {
            setList((ArrayList<Employee>) EmployeeDao.showAllEmployeeInfo());
            forward = "success";
        }
        return forward;
    }
    public String insertEmployee() {

        String forward = "failure";
        boolean result = EmployeeDao.insertEmployeeInfo(this);
        if (result) {
            setList((ArrayList<Employee>) EmployeeDao.showAllEmployeeInfo());
            forward = "success";
        }
        return forward;
    }
    public String showAllEmployee() {

        String forward = "failure";
        session = ActionContext.getContext().getSession();
        if(session.get("user") == null)
        {
            return "nosession";
        }
        setList((ArrayList<Employee>) EmployeeDao.showAllEmployeeInfo());
        if (!list.isEmpty()) {
            
            forward = "success";
        }
        return forward;
    }
    public String searchEmployee() {

        String forward = "failure";
        //String empName = String.valueOf(this.getEmployeeName());
        
        session = ActionContext.getContext().getSession();
        if(session==null)
        {
            return "nosession";
        }
        
        setList(EmployeeDao.showAllEmployeeInfo(this.getFirstName(),this.getDesignation(), this.getSalary()));
        if (!list.isEmpty()) {
            
            forward = "success";
        }
        return forward;
    }
    public String validateEmployee() {

        String forward = "failure";
        //String empName = String.valueOf(this.getEmployeeName());
        boolean result = EmployeeDao.validateUser(this.getEmail(),this.getPassword());
        
        if (result) {
            User user=EmployeeDao.getUser(this.getEmail(),this.getPassword());
            session = ActionContext.getContext().getSession();
            session.put("user", user);
            
            
            forward = "success";
        }
        System.out.print("Hello\n\n\n\n");
        
        return forward;
    }
    public String roleFunction(){
        String forward = "failure";
        setRoleList((ArrayList<Role>)EmployeeDao.getRole());
        forward = "success";
        return forward;
    }
    
    public String logOff() {

        String forward = "failure";
        //String empName = String.valueOf(this.getEmployeeName());
        session = ActionContext.getContext().getSession();
        if(session==null)
            forward="success";
        else if(session.containsKey("user")){
            session.remove("user");
            forward="success";
        }

        return forward;
    }
    
    //

    /**
     * @return the list
     */
    public ArrayList<Employee> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<Employee> list) {
        this.list = list;
    }

    /**
     * @return the password
     */
//    public String getPassword() {
//        return password;
//    }
//
//    /**
//     * @param password the password to set
//     */
//    public void setPassword(String password) {
//        this.password = password;
 //   }

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
     * @return the roleId
     */

    /**
     * @return the employeeId
     */
    

}
