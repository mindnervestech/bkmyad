package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Adcategory;
import models.AddressDetails;
import models.Basicrate;
import models.ComposedAdSave;
import models.Newspaperdetails;
import models.Order;
import models.State;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodel.AddressDetailsVM;
import viewmodel.BasicrateVM;
import viewmodel.OrderListVM;
//import views.html.myaccount;


public class MyAccountController extends Controller {
	
	//get the orderList for current logged in  user
	@Transactional
	public static Result getAllUserOrder(String UserId) {
	  List<Order> allOrderList = Order.getAllOrderList(UserId);
	
		List<OrderListVM> listOfOrder = new ArrayList<OrderListVM>();
	
		for (Order orderlistVM: allOrderList) {
			OrderListVM vm = new OrderListVM(orderlistVM);
			listOfOrder.add(vm);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("results", listOfOrder);
	
		return ok(Json.toJson(map));
	}
	
	@Transactional
    	public static Result getaddressDetailsofUser() {
		String  emailId = session().get("emailId"); 
		System.out.println("session emailid "+emailId);
		AddressDetails address = AddressDetails.getAddressDetails(emailId);
		System.out.println("address Form query"+address);
		if(!(address == null)){
		List<AddressDetailsVM> addressDetails = new ArrayList<AddressDetailsVM>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("addressDetails", address);
		return ok(Json.toJson(map));
		}
		else{
			return ok();
		}
	}
	
}
