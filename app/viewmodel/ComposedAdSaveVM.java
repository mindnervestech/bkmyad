package viewmodel;

import java.util.Date;

import models.Basicrate;
import models.ComposedAdSave;
import models.Order;

public class ComposedAdSaveVM {

	   public String  OrderID;
	   public String  cc_bid;
	   public String  cc_orderNo;
	   public String   cc_category;
	   public String  bank_name;
	   public String bankMsg;
	   public float TotalCost;
	   public String userEmailId;
	   public Date orderDate;
	   
	   public ComposedAdSaveVM(Object[] composedAdSaveVM) {
		   this.OrderID =(String)composedAdSaveVM[0];
		   this.userEmailId =(String)composedAdSaveVM[1];
		   this.cc_category =(String)composedAdSaveVM[6];		   
		   this.TotalCost =(float)composedAdSaveVM[2];
		   this.bankMsg =(String)composedAdSaveVM[3];
		   this.bank_name =(String)composedAdSaveVM[4];
		   this.cc_bid =(String)composedAdSaveVM[5];
		   this.cc_orderNo  = (String)composedAdSaveVM[6];
		 //  this.orderDate = (Date)composedAdSaveVM[7];
	   
	   }
	   
	  /* public ComposedAdSaveVM(Order order, ComposedAdSave composedAdSave) {
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
		   this.numberOfWords = composedAdSave.numberOfWords;
		   this.userEmailId =composedAdSave.userEmailId;
		  
	   }
	   */
	
}
