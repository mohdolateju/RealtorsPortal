/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Mohammed
 */
public class LogoutAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    /**
     * This method removes the session Attributes that was set in when
     * the user loggen in
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session=request.getSession();
        session.removeAttribute("username");
        session.removeAttribute("role");
        return mapping.findForward(SUCCESS);
    }
}
