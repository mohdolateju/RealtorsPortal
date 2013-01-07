/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.bean;

import com.myapp.model.AgentModel;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author Mohammed
 * This update the profile of admin
 */
public class AdminUpdateProfileFormBean extends org.apache.struts.action.ActionForm {

    private String firstname;
    private String middlename;
    private String lastname;
    private String email;
    private String userName;

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }


    public AdminUpdateProfileFormBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This validate method checks the specified parameters if they are empty
     * then no action is taken if they are not empty and consistent
     * the Admin's profile is updated
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        AgentModel psm=new AgentModel();
        String username=(String) request.getSession().getAttribute("username");
        ArrayList userdata=psm.getUserData(username);

        String Firstname=(String)userdata.get(0);
        String Middlename=(String)userdata.get(1);
        String Lastname=(String)userdata.get(2);
        String Email=(String)userdata.get(3);
        String Username=(String)userdata.get(4);


        ActionErrors errors = new ActionErrors();


        if(Firstname.equals(firstname)||firstname.isEmpty()){

        }else{
             psm.setFirstname(username, firstname);
        }

        if(Middlename.equals(middlename)||middlename.isEmpty()){

        }else{
             psm.setMiddlename(username, middlename);
        }

        if(Lastname.equals(lastname)||lastname.isEmpty()){

        }else{
             psm.setLastname(username, lastname);
        }

        if(Email.equals(email)||email.isEmpty()){

        }else if(psm.Emailexist(email)){
            errors.add("emailexist",new ActionMessage("error.email.exist"));
        }
        else if (!psm.Emailexist(email)){
             psm.setEmail(username, email);
        }

        if(username.equals(userName)||userName==null){

        }else if(psm.Usernameexist(userName)){
            errors.add("usernameexist",new ActionMessage("error.username.exist"));
        }
        else if (!psm.Usernameexist(userName)){
             psm.setUsername(username, userName);
        }
        
        return errors;
    }
}
