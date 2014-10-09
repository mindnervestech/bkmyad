package viewmodel;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Transient;


import models.City;
import models.Newspaperdetails;


public class NewspaperdetailsVM {
	public String NewsId;
	public String Nameofthenewspaper;
	//public String LogoFileExtention;
//	public String LogoName;
	public String Addedition;
	@Transient
	public List<String> NameofCities;
	
	/*@Transient
	public List<SelectionVM> NameofCitiesVM;*/
	
	@Transient
	public List<String> Unit;
	
	@Transient
	public List<String> Value;
	
	public String Nameofcities;
	public String BasicratesperText;
	public String BasicratesperClasified;
	public String Beforebookingdate;
	public String Allow;
	public String Statename;
    

    
    public NewspaperdetailsVM(Newspaperdetails newspaperdetails) {
    	    	
    	this.NewsId = newspaperdetails.NewsId;
    	this.Nameofthenewspaper =newspaperdetails.Nameofthenewspaper; 
    	/*this.LogoFileExtention = newspaperdetails.LogoFileExtention;
    	this.LogoName = newspaperdetails.LogoName;*/
    	this.Addedition = newspaperdetails.Addedition;
    	this.Nameofcities = newspaperdetails.Nameofcities;
    	
    	this.BasicratesperText = newspaperdetails.BasicratesperText;
    	this.BasicratesperClasified = newspaperdetails.BasicratesperClasified;
    	this.Beforebookingdate = newspaperdetails.Beforebookingdate;
    	this.Allow = newspaperdetails.Allow;
    	this.Statename = newspaperdetails.Statename;
    	    	
    }
    
	
}









