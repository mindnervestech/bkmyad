package viewmodel;

import models.ComposedAdSave;
import models.Order;

public class ComposedAdSaveVMInvoice {
	public Long OID;
	   public String IpAddress;
	   public String  OrderID;
	   public String Nameofthenewspaper;
	   public String City;
	   public String Adtext;
	   public String TotalNoofline;
	   public String Linecost;
	   public String Tick;
	   public float TickRate;
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
	   public String orderDate;
	   public String freeunit;
	   public float extra;
	   public float totalExtraCost;
	   public float totalUnitCost;
	   public int noOfImpression;
	   public float rate;
	   public String bgColorSelect; 
	   public String  adbookedId;
	   
	   public ComposedAdSaveVMInvoice(ComposedAdSave composedAdSave) {
	    	this.OrderID=composedAdSave.OrderID;
	    	this.orderDate=composedAdSave.orderDate;
	    	this.userEmailId=composedAdSave.userEmailId;
	    	this.Adtext=composedAdSave.Adtext;
	    	this.Nameofthenewspaper=composedAdSave.Nameofthenewspaper;
	    	this.TotalCost=composedAdSave.TotalCost;
	    	this.Bgcolor = composedAdSave.Bgcolor;
	    	this.Border = composedAdSave.Border;
	    	this.PublishDate = composedAdSave.PublishDate;
	    	this.numberOfWords = composedAdSave.numberOfWords;
	    	this.paymentOption = composedAdSave.paymentOption;
	    	this.Tick = composedAdSave.Tick;
	    	this.Category = composedAdSave.Category;
	    	this.City = composedAdSave.City;
	    	System.out.println("this.paymentOption"+this.paymentOption);
	        
	    	
	    }
	  
}
