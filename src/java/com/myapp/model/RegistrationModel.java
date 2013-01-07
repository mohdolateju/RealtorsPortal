/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.model;

import com.myapp.bean.DurationBean;
import com.myapp.bean.PackageBean;
import com.myapp.bean.PriceBean;
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
 * This class is used to Register users into the website
 */
public class RegistrationModel {

    /**
     The methode loads all the subsciption packages which the users can be registered to
     */
    @SuppressWarnings("empty-statement")
    public ArrayList Loadsubpackages(){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        ArrayList<PackageBean> subpackage=new ArrayList<PackageBean>();

        String query="SELECT package_name, duration, price FROM subscription_package " +
                "WHERE package_name!='admin'";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                PackageBean pckgBean = new PackageBean();
                pckgBean.setSubPackage(rs.getString("package_name"));
                pckgBean.setDuration(rs.getInt("duration"));
                pckgBean.setPrice(rs.getFloat("price"));
                subpackage.add(pckgBean);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
        return subpackage;
    }

    /**
     * The method loads the all the prices which the users will pay for the Subscription package
     */
    public ArrayList Loadsubprices(){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        ArrayList subpackage=new ArrayList();

        String query="SELECT price FROM subscription_package where package_name!='admin'";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                PriceBean prcBean = new PriceBean();
                prcBean.setPrice(rs.getFloat("price"));
                subpackage.add(prcBean);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
        return subpackage;
    }

    /**The duration of each subscription package is retursn as an ArrayList*/
    public ArrayList Loadsubdurations(){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        ArrayList subpackage=new ArrayList();

        String query="SELECT duration FROM subscription_package where package_name!='admin'";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                DurationBean drnBean = new DurationBean();
                drnBean.setDuration(rs.getInt("duration"));
                subpackage.add(drnBean);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
        return subpackage;
    }

    /**The method creates new user in the users table*/
        public int CreateNewAccount(String firstname,String middlename,String lastname,String username,String passWord,String email,
                String role,String Package,int Creditno){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        PreparedStatement pst=null;
        int user_id=0;
        int status=0;
        AdminModel psm=new AdminModel();
        user_id=psm.getUserId(username);
        String query="INSERT INTO users (user_id, username, password, firstname, middlename, lastname, email, role, status, package_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, '1', ?);";
        try {
            pst = con.prepareStatement(query);
            RegistrationModel rm=new RegistrationModel();
            int package_id=rm.getPackageId(Package);
            pst.setInt(1, user_id);
            pst.setString(2, username);
            pst.setString(3, passWord);
            pst.setString(4, firstname);
            pst.setString(5, middlename);
            pst.setString(6, lastname);
            pst.setString(7, email);
            pst.setString(8, role);
            pst.setInt(9, package_id);
            status=pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
         return status;
    }

/**
 The method gets the package id of a particular subscription pacakge
 */
    public int getPackageId(String subpackage){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        int userData=0;

        String query="SELECT package_id from subscription_package WHERE package_name=?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, subpackage);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                userData=rs.getInt("package_id");

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
        return userData;
    }

    /**
     The method inserts data into the transactionlog table
     */
    public int transactlog(String username,int Creditno,String transaction_type){
        Connect cnt=new Connect();
        Connection con=cnt.connect();
        PreparedStatement pst=null;
        int user_id=0;
        int status=0;
        AdminModel psm=new AdminModel();
        user_id=psm.getUserId(username);
        String query="INSERT INTO transaction_log (credit_cardno, user_id, transaction_type) VALUES (?, ?, ?);";
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1, Creditno);
            pst.setInt(2, user_id);
            pst.setString(3, transaction_type);
            status=pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RegistrationModel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IndexOutOfBoundsException ex){
        ex.getMessage();
        };
         return status;
    }
}