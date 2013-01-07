/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action.load;

import com.myapp.bean.PackageBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.myapp.model.RegistrationModel;
import java.util.ArrayList;

/**
 *
 * @author Mohammed
 */
public class LoadRegAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
/**
 * Load the Subscription packages that the subscribing users can select
 */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        RegistrationModel rm=new RegistrationModel();
        try{
            ArrayList<PackageBean> pckgList = rm.Loadsubpackages();
            request.getSession().setAttribute("packages", pckgList);
            
        }catch(IndexOutOfBoundsException ex){
            ex.getMessage();
        }
        return mapping.findForward(SUCCESS);
    }
}
