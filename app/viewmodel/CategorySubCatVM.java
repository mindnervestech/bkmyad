package viewmodel;

import java.text.SimpleDateFormat;


import models.Adsubcategory;


public class CategorySubCatVM {
     public String CSID;
     public String CID;
     public String cname;
     public String Sucategory;
    

    
    public CategorySubCatVM(Object[] categorySubCatVM) {
    	
    	this.CID=(String)categorySubCatVM[0];
       	this.cname=(String)categorySubCatVM[1];
       	this.CSID = (String)categorySubCatVM[3];
    	this.Sucategory=(String)categorySubCatVM[2];
    }
   
	
}
