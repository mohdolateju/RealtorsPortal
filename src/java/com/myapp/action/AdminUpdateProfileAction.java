/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Mohammed
 */
public class AdminUpdateProfileAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    /**
     * This Action update the profile of the user and sets an attribute in the
     * request object to notify the user
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionErrors errors = new ActionErrors();
        if(!errors.isEmpty()){
        return mapping.getInputForward();
        }else if(errors.isEmpty()){
            String Updatesuccess="Profile successfully Updated";
            request.setAttribute("success", Updatesuccess);
        }

        return mapping.findForward(SUCCESS);
    }
}
