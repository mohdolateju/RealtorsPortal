/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.myapp.struts.Connect;
/**
 *
 * @author Mohammed
 * This class is used to login a users into realtors portal
 */
public class LoginModel {
Connect cnt=new Connect();
Connection con=cnt.connect();
PreparedStatement pstmt = null;
ResultSet rs = null;

/**
 * The methode validate the user by verifying if the username and password exist
 * in a single row in the users table
 */
public String validateUser(String username, String password){
       String role=null;
       try {
            
            String query = "SELECT role from users WHERE username=? AND password=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
             role  = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }



     finally {
            try {
                pstmt.close();
                rs.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
           

           return role;
           }

/**
 * The method verifyies if the user is active by checking the status columns in the users table
 */
public boolean ActiveUser(String username, String password){
        boolean status=false;
        try {
            String query = "SELECT status from users WHERE username=? AND password=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                status = rs.getBoolean(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        } 

     

     finally {
            try {
                pstmt.close();
                rs.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            }
           }

         return status;
           }

           }

