/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.bean;

import com.myapp.model.AgentModel;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Mohammed
 */
public class AgentChangePasswordFormBean extends org.apache.struts.action.ActionForm {
    
    private String currentPassword;
    private String password1;
    private String password2;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }


    /**
     *
     */
    public AgentChangePasswordFormBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This method is used to verify for the parameters' consistency and
     * change the password for the user
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if(!password1.equals(password2)){
            errors.add("passwordnotequal",new ActionMessage("error.password.notequal"));
            return errors;
        }
        AgentModel psm=new AgentModel();
        String username=(String)request.getSession().getAttribute("username");
        String oldpassword=psm.getPassword(username);
        if(oldpassword.equals(currentPassword)){
            psm.setpassword(username, password1);
            return errors;
        }else{
            errors.add("passwordincorrect",new ActionMessage("error.password.incorrect"));
            
        }


        return errors;
    }
}
