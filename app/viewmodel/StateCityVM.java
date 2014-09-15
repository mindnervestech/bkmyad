package viewmodel;

import java.text.SimpleDateFormat;


import models.City;


public class StateCityVM {
     public String CID;
     public String Statename;
     public String Cityname;
    

    
    public StateCityVM(City city) {
    	
    	this.CID=city.CID;
       	this.Statename=city.Statename;
    	this.Cityname=city.Cityname;
    }
    
	
}
