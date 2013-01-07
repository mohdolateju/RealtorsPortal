/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Mohammed
 */
public class AgentChangePasswordAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
 /**
     This action checks if the there are no errors and then sets an Attribute in the
     request object which will inform the user that the Password was successfully changed
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionErrors errors=new ActionErrors();

        if(errors.isEmpty()){
            String passwordsuccess="Password Successfully Changed";
            request.setAttribute("passwordsuccess",passwordsuccess);
        }else{
            return mapping.getInputForward();
        }
        return mapping.findForward(SUCCESS);
    }
}
