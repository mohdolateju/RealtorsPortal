/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.bean.AdsBean;
import com.myapp.bean.AllAdsBean;
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
public class AllAdsAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    public ArrayList ImagePaths;
    
    /**
     * This method gets all data from the ads table and load it
     * into the AllAdsBean then sets the AllAdsBeand as an Attribute in the
     * request paramater.
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrivateSellerModel psm=new PrivateSellerModel();
        AllAdsBean imb=new AllAdsBean();
        ArrayList adsimagepaths=psm.getUserAllAdsNames();
        imb.setImagePath(adsimagepaths);
        ArrayList adslocation=psm.getUserAllAdsLocation();
        imb.setLocation(adslocation);
        ArrayList adscategory=psm.getUserAllAdscategory();
        imb.setCategory(adscategory);
        ArrayList adstype=psm.getUserAllAdsTypes();
        imb.setType(adstype);
        ArrayList adsdescription=psm.getUserAllAdsDescription();
        imb.setDescription(adsdescription);
        request.setAttribute("adsbean", imb);
        return mapping.findForward(SUCCESS);
    }
}
