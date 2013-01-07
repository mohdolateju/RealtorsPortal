/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action.load;

import com.myapp.bean.load.LoadSubPackageFormBean;
import com.myapp.model.AdminModel;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Mohammed
 */
public class AdminLoadSubPackageAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    /**
     * This method load the data from subscription_package table
     * so that the admin can view his current subscription packages
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AdminModel am=new AdminModel();
        LoadSubPackageFormBean lspbn=new LoadSubPackageFormBean();
        ArrayList subpackage=am.getSubPackages();
        for(int i=0;subpackage.size()>i;i+=4){
            lspbn.setPackage_id(subpackage.get(i));
            lspbn.setPackage_name(subpackage.get(i+1));
            lspbn.setDuration(subpackage.get(i+2));
            lspbn.setPrice(subpackage.get(i+3));
        }
        request.setAttribute("subpackage",lspbn);
        
        return mapping.findForward(SUCCESS);
    }
}
