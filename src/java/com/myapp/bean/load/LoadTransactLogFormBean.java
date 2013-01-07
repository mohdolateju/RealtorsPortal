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
* This is where all the information in the transact log table are stored
 * before the they are display in the transanct log page
 */
public class LoadTransactLogFormBean extends org.apache.struts.action.ActionForm {
    private ArrayList creditCardNo=new ArrayList();
    private ArrayList transactUsername=new ArrayList();
    private ArrayList date=new ArrayList();
    private ArrayList type=new ArrayList();

    public ArrayList getCreditCardno() {
        return creditCardNo;
    }

    public ArrayList getTransactUsername() {
        return transactUsername;
    }

    public void setTransactUsername(String transactUsername) {
        this.transactUsername.add(transactUsername);
    }

    public void setCreditCardno(Object creditCardnod) {
        this.creditCardNo.add(creditCardnod);
    }

    public ArrayList getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date.add(date);
    }

    public ArrayList getType() {
        return type;
    }

    public void setType(String type) {
        this.type.add(type);
    }





    /**
     *
     */
    public LoadTransactLogFormBean() {
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
