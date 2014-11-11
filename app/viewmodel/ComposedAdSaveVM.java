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
		   this.cc_orderNo  = (String)composedAdSaveVM[7];
		   this.orderDate = (Date) composedAdSaveVM[8];
	 
	   }
	   
	 	
}
