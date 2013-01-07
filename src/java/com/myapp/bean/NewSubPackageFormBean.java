/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.bean;

import com.myapp.model.AdminModel;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Mohammed
 */
public class NewSubPackageFormBean extends org.apache.struts.action.ActionForm {

    private String pacKageName;
    private int duRation;
    private float priCe;

    public String getPacKageName() {
        return pacKageName;
    }

    public void setPacKageName(String pacKageName) {
        this.pacKageName = pacKageName;
    }

    public int getDuRation() {
        return duRation;
    }

    public void setDuRation(int duRation) {
        this.duRation = duRation;
    }

    public float getPriCe() {
        return priCe;
    }

    public void setPriCe(float priCe) {
        this.priCe = priCe;
    }




    /**
     *
     */
    public NewSubPackageFormBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This method test if the parameter are consistent and if they are
     * create a new subscription package
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if(pacKageName.trim().isEmpty()||duRation==0||priCe==0){
            errors.add("emptyfield", new ActionMessage("error.empty.field"));
        }
        if(errors.isEmpty()){
            AdminModel am=new AdminModel();
            if(am.NewPackage(pacKageName, duRation, priCe)==0){
                errors.add("didnotsucceed",new ActionMessage("error.package.notsucceed"));
            }            
        }

        return errors;
    }
}
