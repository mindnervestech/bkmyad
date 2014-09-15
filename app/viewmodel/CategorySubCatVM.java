package viewmodel;

import java.text.SimpleDateFormat;


import models.Adsubcategory;


public class CategorySubCatVM {
     public String CSID;
     public String cname;
     public String Sucategory;
    

    
    public CategorySubCatVM(Adsubcategory adsubcategory) {
    	
    	this.CSID=adsubcategory.CSID;
       	this.cname=adsubcategory.cname;
    	this.Sucategory=adsubcategory.Sucategory;
    }
    
	
}
