package viewmodel;

import models.Basicrate;
import models.ComposedAdSave;

public class OrderListVM {
	 public Long OID;
	   public String IpAddress;
	   public String  OrderID;
	   public String Nameofthenewspaper;
	   public String City;
	   public String Adtext;
	   public String TotalNoofline;
	   public String Linecost;
	   public String Tick;
	   public String TickRate;
	   public String Bgcolor;
	   public float BgcolorRate;
	   public String Border;
	   public float BorderCost;
	   public String Noofads;
	   public String PublishDate;
	   public String BasicRate;
	   public float TotalCost;
	   public String Guid;
	   public String Extraborderper;
	   public String Extrabgper;
	   public String Tickper;
	   public String  Category;
	   public String  Subcategory;
	   public int numberOfWords;
	   public String paymentOption;
	   public String userEmailId;
	   public String Offer;
	   public String Enhancement;
	   public OrderListVM(ComposedAdSave composedAdSave) {
	    	
	    	this.OrderID=composedAdSave.OrderID;
	    	this.Nameofthenewspaper=composedAdSave.Nameofthenewspaper;
	    	this.City=composedAdSave.City;
	    	this.Adtext=composedAdSave.Adtext;
	    	this.PublishDate=composedAdSave.PublishDate;
	    	this.Category=composedAdSave.Category;
	    	this.Border=composedAdSave.Border;
	    	this.Subcategory=composedAdSave.Subcategory;
	    	this.paymentOption=composedAdSave.paymentOption;
	    	this.Tick=composedAdSave.Tick;
	    	this.Category=composedAdSave.Category;
	    	this.Extraborderper=composedAdSave.Extraborderper;
	    	this.Extrabgper=composedAdSave.Extrabgper;
	    	this.Tickper=composedAdSave.Tickper;
	    	this.userEmailId=composedAdSave.userEmailId;
	    	this.City=composedAdSave.City;
	    	//this.City=composedAdSave.City;
	    }
}
