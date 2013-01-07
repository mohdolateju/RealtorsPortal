/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action.load;

import com.myapp.bean.load.LoadTransactLogFormBean;
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
public class AdminLoadTransactAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    /**
     * This method loads the all the data from the transaction table to the TransactionLogFormBean
     * so that admin can view the transaction log
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AdminModel am=new AdminModel();
        LoadTransactLogFormBean ltfbn=new LoadTransactLogFormBean();
        ArrayList transactlog=am.getTransaction();
        for(int i=0;transactlog.size()>i;i+=4){
            ltfbn.setCreditCardno(transactlog.get(i));
            int userid=Integer.parseInt(transactlog.get(i+1).toString());
            ltfbn.setTransactUsername(am.getUsername(userid));
            ltfbn.setDate(transactlog.get(i+2));
            ltfbn.setType(transactlog.get(i+3).toString());
        }
        request.setAttribute("translog",ltfbn);
        
        return mapping.findForward(SUCCESS);
    }
}
