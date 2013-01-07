/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.model;

import com.myapp.struts.Connect;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohammed
 * This class used mostly used by components for the Admin
 */
public class AdminModel {

    /**
     Queries the database and gets information about the user such as firstname middlename and email
     from the users table in the
     * database
     */
    @SuppressWarnings("empty-statement")
    public ArrayList getUserData(String username){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        ArrayList userData=new ArrayList();

        String query="SELECT firstname,middlename,lastname,email,username FROM users where username=?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                userData.add(rs.getString("firstname"));
                userData.add(rs.getString("middlename"));
                userData.add(rs.getString("lastname"));
                userData.add(rs.getString("email"));
                userData.add(rs.getString("username"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
        return userData;
    }


    /**
     * This method is used to change the username of a user in the users table
     */
    @SuppressWarnings("empty-statement")
    public int setUsername(String username,String newusername){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        PreparedStatement pst=null;
        int user_id=0;
        int status=0;
        AdminModel psm=new AdminModel();
        user_id=psm.getUserId(username);
        String query="UPDATE users SET username=? WHERE user_id=?";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, newusername);
            pst.setInt(2,user_id);
            status=pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
         return status;
    }

        /**
     Changes the email of a user by using the database username and email parameters
     */
    @SuppressWarnings("empty-statement")
    public int setEmail(String username,String email){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        PreparedStatement pst=null;
        int user_id=0;
        int status=0;
        AdminModel psm=new AdminModel();
        user_id=psm.getUserId(username);
        String query="UPDATE users SET email=? WHERE user_id=?";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setInt(2,user_id);
            status=pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
         return status;
    }

        /**
     changes the firstname of a user this method is used to update the profile of a user
     */
    @SuppressWarnings("empty-statement")
    public int setFirstname(String username,String firstname){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        PreparedStatement pst=null;
        int user_id=0;
        int status=0;
        AdminModel psm=new AdminModel();
        user_id=psm.getUserId(username);
        String query="UPDATE users SET firstname=? WHERE user_id=?";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, firstname);
            pst.setInt(2,user_id);
            status=pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
         return status;
    }

    /**
     changes the lastname of a user this method is used to update the profile of a user
     */
    @SuppressWarnings("empty-statement")
    public int setLastname(String username,String lastname){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        PreparedStatement pst=null;
        int user_id=0;
        int status=0;
        AdminModel psm=new AdminModel();
        user_id=psm.getUserId(username);
        String query="UPDATE users SET lastname=? WHERE user_id=?";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, lastname);
            pst.setInt(2,user_id);
            status=pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
         return status;
    }

         /**
     changes the middlename of a user this method is used to update the profile of a user
     */
    @SuppressWarnings("empty-statement")
    public int setMiddlename(String username,String Middlename){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        PreparedStatement pst=null;
        int user_id=0;
        int status=0;
        AdminModel psm=new AdminModel();
        user_id=psm.getUserId(username);
        String query="UPDATE users SET middlename=? WHERE user_id=?";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, Middlename);
            pst.setInt(2,user_id);
            status=pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
         return status;
    }

    /**
   this method gets the user id of a user from the database
     */
    @SuppressWarnings("empty-statement")
    public int getUserId(String username){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        int userData=0;

        String query="SELECT user_id from users WHERE username=?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                userData=rs.getInt("user_id");

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
        return userData;
    }

        /**
     Gets the username of a user  form the database using its userid
     */
    @SuppressWarnings("empty-statement")
    public String getUsername(int userid){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        String userData=null;

        String query="SELECT username from users WHERE user_id=?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, userid);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                userData=rs.getString("username");

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
        return userData;
    }

        /**
     Gets the passwowrd of a user  form the database in form of a String
     */
        public String getPassword(String username){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        String userData=null;

        String query="SELECT password from users WHERE username=?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                userData=rs.getString("password");

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
        return userData;
    }

     /**
     used to set a password of user this method is used to manage the profile of a user
     */
    @SuppressWarnings("empty-statement")
    public int setpassword(String username,String password){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        PreparedStatement pst=null;
        int user_id=0;
        int status=0;
        AdminModel psm=new AdminModel();
        user_id=psm.getUserId(username);
        String query="UPDATE users SET password=? WHERE user_id=?";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, password);
            pst.setInt(2,user_id);
            status=pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
         return status;
    }

            /**
     This method verifies if the username exist if the username exists the
     * the method returns true if the username does not exist it  returns
     * a false
     */
        public boolean Usernameexist(String username) {
        boolean returnboolean = false;
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        PreparedStatement pst=null;
        try{


            String query="SELECT user_id FROM users WHERE username= ?";
            pst=con.prepareStatement(query);
            pst.setString(1, username);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
            returnboolean=true;
            }else{
            returnboolean=false;
            }
           }
         catch(Exception e){}

     return returnboolean;
    }

               /**
        This method tests the database to find out if the email exist if the email exist
        * the method returns true if the email doesnt not already exist the method returs
        * false
        *
        */
        public boolean Emailexist(String email) {
        boolean returnboolean = false;
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        PreparedStatement pst=null;
        try{


            String query="SELECT user_id FROM users WHERE email= ?";
            pst=con.prepareStatement(query);
            pst.setString(1, email);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
            returnboolean=true;
            }else{
            returnboolean=false;
            }
           }
         catch(Exception e){}

     return returnboolean;
    }

        /*
         This method return all the data in the transaction_log table
         */
            public ArrayList getTransaction() {
        ArrayList transactlog = new ArrayList();
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        PreparedStatement pst=null;
        try{


            String query="SELECT * FROM transaction_log";
            pst=con.prepareStatement(query);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
            transactlog.add(rs.getInt("credit_cardno"));
            transactlog.add(rs.getInt("user_id"));
            transactlog.add(rs.getTimestamp("date"));
            transactlog.add(rs.getString("transaction_type"));
            }
           }
         catch(Exception e){}

     return transactlog;
    }

            /**
             The method returns all the data from the subsciption_package table
             */
   public ArrayList getSubPackages() {
        ArrayList transactlog = new ArrayList();
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        PreparedStatement pst=null;
        try{


            String query="SELECT * FROM subscription_package";
            pst=con.prepareStatement(query);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
            transactlog.add(rs.getInt("package_id"));
            transactlog.add(rs.getString("package_name"));
            transactlog.add(rs.getInt("duration"));
            transactlog.add(rs.getFloat("price"));
            }
           }
         catch(Exception e){}

     return transactlog;
    }


   /**
    * The method creates a new subscriptions package in the subsciption package
    * table
    */
    public int NewPackage(String package_name,int Package_duration, float price){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        int result=0;

        String query="INSERT INTO subscription_package (package_name,duration,price) VALUES (?, ?, ?)";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, package_name);
            pst.setInt(2, Package_duration);
            pst.setFloat(3, price);
            result=pst.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
        return result;
    }
}
