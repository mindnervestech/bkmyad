package viewmodel;

import models.Basicrate;
import models.ComposedAdSave;
import models.Order;

public class ComposedAdSaveVM {

	   public String  OrderID;
	   public String Nameofthenewspaper;
	   public String City;
	   public String Adtext;
	   public String Tick;
	   public float TickRate = 0;
	   public String Bgcolor;
	   public float BgcolorRate;
	   public String Border;
	   public float BorderCost;
	   public String PublishDate;
	   public String BasicRate;
	   public float TotalCost;
	   public String Extraborderper;
	   public String Extrabgper;
	   public String Tickper;
	   public String  Category;
	   public String  Subcategory;
	   public int numberOfWords;
	   public String paymentOption;
	   public String userEmailId;
	   public String orderDate;
	   public String freeunit;
	   public float extra;
	   public float totalExtraCost;
	   public float totalUnitCost;
	   public int noOfImpression;
	   public float rate;
	   public String bgColorSelect; 
	   public String  adbookedId;
	   public String  cc_bid;
	   public String  cc_orderNo;
	   public String   cc_category;
	   public String  bank_name;
	   public String bankMsg;
	   
	    
	   public ComposedAdSaveVM(Order order, ComposedAdSave composedAdSave) {
		   this.OrderID=composedAdSave.OrderID;
		   this.Nameofthenewspaper=composedAdSave.Nameofthenewspaper;
		   this.City=composedAdSave.City;
		   this.Adtext=composedAdSave.Adtext;
		   this.Tick=composedAdSave.Tick;
		   this.TickRate=composedAdSave.TickRate;
		   this.Category=composedAdSave.Category;
		   this.bgColorSelect=composedAdSave.bgColorSelect;
		   this.Bgcolor = composedAdSave.Bgcolor;
		   this.Border=composedAdSave.Border;
		   this.BorderCost=composedAdSave.BorderCost;
		   this.orderDate=composedAdSave.orderDate;
		   this.PublishDate=composedAdSave.PublishDate;
		   this.TotalCost=composedAdSave.TotalCost;
		   this.cc_bid = order.cc_bid;
		   this.cc_orderNo=order.cc_orderNo;
		   this.cc_category=order.cc_category;
		   this.bank_name=order.bank_name;
		   this.bankMsg=order.bankMsg;
		   this.userEmailId =composedAdSave.userEmailId;
		  
	   }
	   
	
}
