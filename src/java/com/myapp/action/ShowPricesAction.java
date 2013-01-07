/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.bean.PackageBean;
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
public class ShowPricesAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    /**
     * This action gets the selected subscription package as a parameter from the Registration
     * page and sets the price and duration as a request attribute
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ArrayList<PackageBean> pckgList = (ArrayList<PackageBean>) request.getSession().getAttribute("packages");
        String packages = request.getParameter("pacKage");

        for (PackageBean pckgBean : pckgList) {
            if (pckgBean.getSubPackage().equals(packages)) {
                request.setAttribute("curPackage", packages);
                request.setAttribute("prices", pckgBean.getPrice());
                request.setAttribute("duration", pckgBean.getDuration());
                break;

            }
            
        }
        
        return mapping.findForward(SUCCESS);
    }
}
