package viewmodel;


import models.Discountprice;

public class DiscountVM {
	public String Did;
	public String Nameofthenewspaper;
	public String Edition;
	public String Dtotalprice;
	public String Exstracostperline;
	public String Border;
	public String Backcolor;
	public String SpecialDiscount;
	public String Tick;
	public String Category;
    public String ExtracostperSqcm;
	public String Cities;
	public String Extraborderper="0";
	public String Extrabgper="0";
	public String Tickper="0";
	public String notes="Not Set";
	public String ClasifiedadRate;
	
	  public DiscountVM(Discountprice discountprice) {
	    	this.Did=discountprice.Did;
	    	this.Nameofthenewspaper=discountprice.Nameofthenewspaper;
	    	this.Cities=discountprice.Cities;
	    	this.Edition=discountprice.Edition;
	    	this.Dtotalprice=discountprice.Dtotalprice;
	    	this.Exstracostperline=discountprice.Exstracostperline;
	    	this.Border=discountprice.Border;
	    	this.Backcolor=discountprice.Backcolor;
	    	this.SpecialDiscount=discountprice.SpecialDiscount;
	    	this.Tick=discountprice.Tick;
	    	this.Category=discountprice.Category;
	    	this.Extraborderper =discountprice.Extraborderper;
	    	this.Extrabgper=discountprice.Extrabgper;
	    	this.Tickper = discountprice.Tickper;
	    	this.ExtracostperSqcm=discountprice.ExtracostperSqcm;
	    	this.notes = discountprice.notes;
	    	this.ClasifiedadRate = discountprice.ClasifiedadRate;
	    }

}
