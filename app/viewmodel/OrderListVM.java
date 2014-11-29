package viewmodel;

import models.Basicrate;
import models.ComposedAdSave;
import models.Order;

public class OrderListVM {
	 
    public String orderId;
	public float total;
	public String email;
	public String cc_orderNo;
	public String cc_bid;
	public String cc_category;
	public String bank_name;
	public String bankMsg;
	
	   public OrderListVM(Order order) {
	    	this.orderId=order.orderId;
	    	this.cc_orderNo=order.cc_orderNo;
	    	this.cc_bid=order.cc_bid;
	    	this.cc_category=order.cc_category;
	    	this.bank_name=order.bank_name;
	    	this.total=order.total;
	    
	    	
	    }
}
