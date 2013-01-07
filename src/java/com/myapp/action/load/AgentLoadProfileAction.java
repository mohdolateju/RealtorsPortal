/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action.load;

import com.myapp.bean.AgentUpdateProfileFormBean;
import com.myapp.model.PrivateSellerModel;
import java.util.ArrayList;
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
public class AgentLoadProfileAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    /**
     * This method load the data about the user so into the Manager profile FormBean
     * so that the user can view his current profile data
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session=request.getSession();
        String username=(String) session.getAttribute("username");
        PrivateSellerModel psm=new PrivateSellerModel();
        try{
        ArrayList userdata=psm.getUserData(username);
        AgentUpdateProfileFormBean lpb=new AgentUpdateProfileFormBean();
        lpb.setFirstname((String)userdata.get(0));
        lpb.setMiddlename((String)userdata.get(1));
        lpb.setLastname((String)userdata.get(2));
        lpb.setEmail((String)userdata.get(3));
        lpb.setUsername((String)userdata.get(4));
        request.setAttribute("userdata", lpb);
        }catch(IndexOutOfBoundsException ex){
        ex.getMessage();
        }
        return mapping.findForward(SUCCESS);
    }
}
