/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.bean;

import com.myapp.model.AdminModel;
import com.myapp.model.RegistrationModel;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Mohammed
 */
public class RegistrationFormBean extends org.apache.struts.action.ActionForm {
    

    
    private ArrayList sub_package;
    private ArrayList duration;
    private ArrayList price;
    

    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String passWord1;
    private String passWord2;
    private String email;
    private String role;
    private String pacKage;
    private int creditNo;

    public int getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(int creditNo) {
        this.creditNo = creditNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPacKage() {
        return pacKage;
    }

    public void setPacKage(String pacKage) {
        this.pacKage = pacKage;
    }

    public String getPassWord1() {
        return passWord1;
    }

    public void setPassWord1(String passWord1) {
        this.passWord1 = passWord1;
    }

    public String getPassWord2() {
        return passWord2;
    }

    public void setPassWord2(String passWord2) {
        this.passWord2 = passWord2;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public ArrayList getPrice() {
        return price;
    }

    public void setPrice(ArrayList price) {
        this.price=price;
    }


    public ArrayList getDuration() {
        return duration;
    }

    public void setDuration(ArrayList duration) {
        this.duration=duration;
    }


    public ArrayList getSub_package() {
        return sub_package;
    }

    public void setSub_package(ArrayList sub_package) {
        this.sub_package=sub_package;
    }

    /**
     *
     */
    public RegistrationFormBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is used to make sure all the parameter entered by the users is consitent before
     * a new user is created
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        AdminModel aml=new AdminModel();

        if(firstName.trim().isEmpty()||lastName.trim().isEmpty()||middleName.trim().isEmpty()
                ||passWord1.trim().isEmpty()||passWord2.trim().isEmpty()||email.trim().isEmpty()||pacKage.isEmpty()){
            errors.add("emptyfield",new ActionMessage("error.empty.field"));
        }
        if(aml.Usernameexist(userName)){
            errors.add("usernameexist",new ActionMessage("error.username.exist"));
        }
        if(!passWord1.equals(passWord2)||passWord1.length()<6){
            errors.add("passwordincorrect",new ActionMessage("reg.error.password.incorrect"));
        }
        if(aml.Emailexist(email)){
            errors.add("emailexist",new ActionMessage("reg.error.email.exist"));
        }
        if(creditNo<100000000||creditNo==0||creditNo>999999999){
            errors.add("incorrectcreditcardno",new ActionMessage("reg.error.creditcard.incorrect"));
        }
        if(email.indexOf("@")==-1||email.indexOf(".com")==-1){
            errors.add("incorrectemail",new ActionMessage("reg.error.email.incorrect"));
        }
        if(errors.isEmpty()){
            RegistrationModel rm=new RegistrationModel();
            int status=rm.CreateNewAccount(firstName, middleName, lastName, userName,
                    passWord1, email, role, pacKage, creditNo);
            if(status==1){
                rm.transactlog(userName, creditNo, "registration");
            }
        }
        return errors;
    }
}
