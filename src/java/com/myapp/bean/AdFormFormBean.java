/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.bean;

import com.myapp.model.PrivateSellerModel;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author Mohammed
 * This FormBean provides the gets the parameters for creating a new Ad
 * and validates the parameters
 */
public class AdFormFormBean extends org.apache.struts.action.ActionForm {

    /*
     The parameters are stated below and the setter  and getter
     * in this form the users need to upload 5 images and specify other information
     * about the ad
     */
    private String category;
    private String type;
    private String location;
    private String description;
    private FormFile image1;
    private FormFile image2;
    private FormFile image3;
    private FormFile image4;
    private FormFile image5;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FormFile getImage1() {
        return image1;
    }

    public void setImage1(FormFile image1) {
        this.image1 = image1;
    }

    public FormFile getImage2() {
        return image2;
    }

    public void setImage2(FormFile image2) {
        this.image2 = image2;
    }

    public FormFile getImage3() {
        return image3;
    }

    public void setImage3(FormFile image3) {
        this.image3 = image3;
    }

    public FormFile getImage4() {
        return image4;
    }

    public void setImage4(FormFile image4) {
        this.image4 = image4;
    }

    public FormFile getImage5() {
        return image5;
    }

    public void setImage5(FormFile image5) {
        this.image5 = image5;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     */
    public AdFormFormBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**

     * In this Validate methode the String parameters are checked to make sure no parameter is empty
     * then the values are inserted into then database to for a creation of a new ad.
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if(location.isEmpty()||description.isEmpty()){
            errors.add("emptyfield",new ActionMessage("error.empty.field"));
        }
            try{
                if(image1.getContentType().equals(null)||image2.getContentType().equals(null)||image3.getContentType().equals(null)
                        ||image4.getContentType().equals(null)||image5.getContentType().equals(null)){
            }
            }catch(NullPointerException z){
            errors.add("noimage",new ActionMessage("error.empty.image"));
            }


        if(errors.isEmpty()){
            PrivateSellerModel psm=new PrivateSellerModel();
            int lastadsid=psm.getLastAdsId()+1;
            String username=(String)request.getSession().getAttribute("username");
            psm.setAdsDetails(username+"ad"+lastadsid, username, category, type, description, location);
        }
        return errors;
    }
    }
