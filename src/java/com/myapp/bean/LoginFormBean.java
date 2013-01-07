/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.bean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import com.myapp.model.LoginModel;

/**
 *
 * @author Mohammed
 */
public class LoginFormBean extends org.apache.struts.action.ActionForm {
   LoginModel lmd=new LoginModel();
   
    private String password;
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





    /**
     *
     */
    public LoginFormBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This methods verifies if the username and password are consistent and if the user is
     * an active user, if any of this conditions if false an error is registered
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getUsername().trim().isEmpty() || getPassword().trim().isEmpty()
               ||!lmd.ActiveUser(username, password)) {
        errors.add("emptyfield", new ActionMessage("login.error"));
            // TODO: add 'error.name.required' key to your resources

        }

        return errors;
    }
}
