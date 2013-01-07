/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action.load;

import com.myapp.bean.AdsBean;
import com.myapp.model.PrivateSellerModel;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Mohammed
 */
public class LoadAdsAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    public ArrayList ImagePaths;
    
    /**
     * This method loads the all the data from the ads table into the AdsBean
     * for posted by a particular user so that they can be viewed and managed
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrivateSellerModel psm=new PrivateSellerModel();
        AdsBean imb=new AdsBean();
        String username=request.getSession().getAttribute("username").toString();
        ArrayList adsimagepaths=psm.getUserAdsNames(username);
        imb.setImagePath(adsimagepaths);
        ArrayList adslocation=psm.getUserAdsLocation(username);
        imb.setLocation(adslocation);
        ArrayList adscategory=psm.getUserAdscategory(username);
        imb.setCategory(adscategory);
        ArrayList adstype=psm.getUserAdsTypes(username);
        imb.setType(adstype);
        ArrayList adsdescription=psm.getUserAdsDescription(username);
        imb.setDescription(adsdescription);
        request.setAttribute("adsbean", imb);
        return mapping.findForward(SUCCESS);
    }
}
