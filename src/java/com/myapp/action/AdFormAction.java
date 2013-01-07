/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.action;

import com.myapp.bean.AdFormFormBean;
import com.myapp.model.PrivateSellerModel;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author Mohammed
 */
public class AdFormAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    /**
     This execute method does the job of getting the Images Uploaded by the user and
     * renaming them by appending the username and ads_id.
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        

        AdFormFormBean bean = (AdFormFormBean) form;
        FormFile image1 = bean.getImage1();
        FormFile image2 = bean.getImage2();
        FormFile image3 = bean.getImage3();
        FormFile image4 = bean.getImage4();
        FormFile image5 = bean.getImage5();
        PrivateSellerModel psm=new PrivateSellerModel();
        int lastadsid=psm.getLastAdsId();
        String username=(String)request.getSession().getAttribute("username");
        ServletContext ctx = getServlet().getServletContext();
        String ImagePath1 = ctx.getRealPath("/images/adsImages/" + username+"ad"+lastadsid+"_1.png");
        String ImagePath2 = ctx.getRealPath("/images/adsImages/" + username+"ad"+lastadsid+"_2.png");
        String ImagePath3 = ctx.getRealPath("/images/adsImages/" + username+"ad"+lastadsid+"_3.png");
        String ImagePath4 = ctx.getRealPath("/images/adsImages/" + username+"ad"+lastadsid+"_4.png");
        String ImagePath5 = ctx.getRealPath("/images/adsImages/" + username+"ad"+lastadsid+"_5.png");
        
            if (!image1.getContentType().equals(null)){
        
        File pix1 = new File(ImagePath1);
        File pix2 = new File(ImagePath2);
        File pix3 = new File(ImagePath3);
        File pix4 = new File(ImagePath4);
        File pix5 = new File(ImagePath5);

        if (!pix1.exists()) {
            pix1.createNewFile();
            FileOutputStream os = new FileOutputStream(pix1);
            os.write(image1.getFileData());
        }

        if (!pix2.exists()) {
            pix2.createNewFile();
            FileOutputStream os = new FileOutputStream(pix2);
            os.write(image2.getFileData());
        }

         if (!pix3.exists()) {
            pix3.createNewFile();
            FileOutputStream os = new FileOutputStream(pix3);
            os.write(image3.getFileData());
        }

         if (!pix4.exists()) {
            pix4.createNewFile();
            FileOutputStream os = new FileOutputStream(pix4);
            os.write(image4.getFileData());
        }

         if (!pix5.exists()) {
            pix5.createNewFile();
            FileOutputStream os = new FileOutputStream(pix5);
            os.write(image5.getFileData());
        }
           }
        

        image1.destroy();
        image2.destroy();
        image3.destroy();
        image4.destroy();
        image5.destroy();
        return mapping.findForward(SUCCESS);
    }
}
