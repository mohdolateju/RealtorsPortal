/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.*;


/**
 *
 * @author Mohammed
 */
public class Connect {

    Connection con = null;

    /*
     This Method connects to the database 'realtors_portal' with a username of aptech and password
     * aptech, this makes the connection to the database dynamic because every method that  connects
     * to the database uses this method.
     */

    public Connection connect(){
       
       try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/realtors_portal", "aptech", "aptech");
            
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

       return con;
           }
    /*
     closes database connection
     */
    public void closeConnect(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
