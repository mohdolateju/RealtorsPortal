/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.bean.load;


import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;


/**
 *
 * @author Mohammed
 * This is where all the information about Subscription Packages are stored
 * before the they are display in the subpackage page
 */
public class LoadSubPackageFormBean extends org.apache.struts.action.ActionForm {
    private ArrayList package_id=new ArrayList();
    private ArrayList package_name=new ArrayList();
    private ArrayList duration=new ArrayList();
    private ArrayList price=new ArrayList();

    public ArrayList getDuration() {
        return duration;
    }

    public void setDuration(Object duration) {
        this.duration.add(duration);
    }

    public ArrayList getPackage_id() {
        return package_id;
    }

    public void setPackage_id(Object package_id) {
        this.package_id.add(package_id);
    }

    public ArrayList getPackage_name() {
        return package_name;
    }

    public void setPackage_name(Object package_name) {
        this.package_name.add(package_name);
    }

    public ArrayList getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price.add(price);
    }






    /**
     *
     */
    public LoadSubPackageFormBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        return errors;
    }
}
