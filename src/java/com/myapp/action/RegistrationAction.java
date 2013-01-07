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
public class RegistrationAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    String account=null;
    /**
     * If there is are no errors, an attribute in the request object is set to
     * notify the user that the account has been created
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionErrors error=new ActionErrors();
        if (!error.isEmpty()){
            return mapping.getInputForward();
        }else{
            request.setAttribute("accountcreated","Your Account has successfully been created");
        }

        return mapping.findForward(SUCCESS);
    }
}
