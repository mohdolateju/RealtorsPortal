/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;


import com.myapp.bean.LoginFormBean;
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

public class LoginAction extends org.apache.struts.action.Action {
    org.apache.struts.action.ActionErrors error=new org.apache.struts.action.ActionErrors();
    com.myapp.model.LoginModel lmd=new com.myapp.model.LoginModel();
    /* forward name="success" path="" */
    private static final String ADMIN = "admin";
    private static final String AGENT = "agent";
    private static final String PRIVATESELLER = "privateseller";
    
    /**
     * This execute method calls the validateUser methode from the model
     * and sets attributes in the session objects depending on the username and the role of the
     * user
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LoginFormBean lfb=(LoginFormBean)form;
        String username = lfb.getUsername();
        String password = lfb.getPassword();
        String role=lmd.validateUser(username, password);
        if(role.equals("admin")){
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("role","admin");
            return mapping.findForward(ADMIN);
        }
        if(role.equals("agent")){
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("role","agent");
            return mapping.findForward(AGENT);
        }
        if(role.equals("privateseller")){
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("role","privateseller");
            return mapping.findForward(PRIVATESELLER);
        }
        return mapping.getInputForward();
    }
}
