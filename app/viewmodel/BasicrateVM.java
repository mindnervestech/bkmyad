package viewmodel;

import java.text.SimpleDateFormat;


import models.Basicrate;


public class BasicrateVM {
     public String BasicRateID;
     public String Nameofthenewspaper;
     public String City;
     public String Textaddrate;
     public String clasifiedadrate;
     public String Exstracostperline;
     public String Border;
     public String Backcolor;
     public String SpecialDiscount;
     public String Tick;
     public String Category;
     public String Extraborderper;
     public String Extrabgper;
     public String Tickper;
     public String ExtracostperSqcm;
     public String Statename;
    public String freewords;
    public BasicrateVM(Basicrate basicrate) {
    	this.BasicRateID=basicrate.BasicRateID;
    	this.Nameofthenewspaper=basicrate.Nameofthenewspaper;
    	this.City=basicrate.City;
    	this.Textaddrate=basicrate.Textaddrate;
    	this.clasifiedadrate=basicrate.clasifiedadrate;
    	this.Exstracostperline=basicrate.Exstracostperline;
    	this.Border=basicrate.Border;
    	this.Backcolor=basicrate.Backcolor;
    	this.SpecialDiscount=basicrate.SpecialDiscount;
    	this.Tick=basicrate.Tick;
    	this.Category=basicrate.Category;
        this.Extraborderper=basicrate.Extraborderper;
        this.Extrabgper=basicrate.Extrabgper;
        this.Tickper=basicrate.Tickper;
    	this.ExtracostperSqcm=basicrate.ExtracostperSqcm;
    	this.Statename=basicrate.Statename;
    	this.Extrabgper = basicrate.Extrabgper;
    	this.Extraborderper = basicrate.Extraborderper;
    	this.Tickper = basicrate.Tickper;
    	this.freewords = basicrate.freewords;
    }
    
    
}
